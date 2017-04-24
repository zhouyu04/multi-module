package com.zzyy.rs.security;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzyy.rs.entities.ResponseMessage;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SystemAuthenticationSuccessHandler extends
        SavedRequestAwareAuthenticationSuccessHandler {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SystemAuthenticationSuccessHandler.class);


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        boolean isAjax = "XMLHttpRequest".equals(request
                .getHeader("X-Requested-With")) || "apiLogin".equals(request
                .getHeader("api-login"));
        response.setHeader("testSessionId", request.getSession().getId());

        if (isAjax) {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            try {

                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setResponseCode("ok");
                ObjectMapper objectMapper = new ObjectMapper();
                JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(response.getOutputStream(),
                        JsonEncoding.UTF8);
                objectMapper.writeValue(jsonGenerator, responseMessage);
            } catch (Exception ex) {
                if (logger.isErrorEnabled()) {
                    logger.error("Could not write JSON:", ex);
                }
                throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
            }
        } else {
            //Call the parent method to manage the successful authentication
            setDefaultTargetUrl("/");
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }

}
