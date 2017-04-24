package com.zzyy.rs.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint extends
        LoginUrlAuthenticationEntryPoint {

    @SuppressWarnings("deprecation")
    public CustomAuthenticationEntryPoint() {
        super("/login");
    }

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException, IOException {
        if (isRestRequest(request)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        } else {
            super.commence(request, response, authException);
        }
    }

    /**
     * Checks if it is a rest request
     *
     * @param request
     * @return
     */
    protected boolean isRestRequest(HttpServletRequest request) {
        boolean isAjax = "XMLHttpRequest".equals(request
                .getHeader("X-Requested-With")) || "apiLogin".equals(request
                .getHeader("api-login"));
        return isAjax;
    }
}
