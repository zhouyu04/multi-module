package com.zzyy.rs.security;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzyy.rs.entities.ResponseMessage;
import com.zzyy.rs.entities.UserInfo;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
    private String accessDeniedUrl = "/403.htm";

    public String getAccessDeniedUrl() {
        return accessDeniedUrl;
    }

    public void setAccessDeniedUrl(String accessDeniedUrl) {
        this.accessDeniedUrl = accessDeniedUrl;
    }


    public void handle(HttpServletRequest request,
                       HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        try {
            UserInfo userDetails = (UserInfo) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            System.out.println("USER DENIED= " + userDetails.getUsername());
        } catch (Exception ex) {
            if (logger.isErrorEnabled()) {
                logger.error("handle", ex);
            }
        }
        String toUrl = "http://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + request.getContextPath()      //项目名称
                + request.getServletPath()      //请求页面或其他地址
                + "?" + (request.getQueryString()); //参数
        boolean isAjax = "XMLHttpRequest".equals(request
                .getHeader("X-Requested-With")) || "apiLogin".equals(request
                .getHeader("api-login"));
        if (isAjax) {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            try {
                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setResponseCode("deny");
                responseMessage.setResponseMessage(toUrl);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(response.getOutputStream(),
                        JsonEncoding.UTF8);
                objectMapper.writeValue(jsonGenerator, responseMessage);
            } catch (Exception ex) {
                logger.info(ex.toString());
                throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
            }
        } else {
            response.sendRedirect(accessDeniedUrl + "?toUrl=" + toUrl);
        }
    }
}
