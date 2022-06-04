package kz.iitu.itse1909r.nugmanova.Security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.addHeader("My header", "GET OUTTA HERE BOY");

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        String errorMessage = "HTTP Status 401 - " + authEx.getMessage();
        writer.println(errorMessage);
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Elvira");
        super.afterPropertiesSet();
    }
}
