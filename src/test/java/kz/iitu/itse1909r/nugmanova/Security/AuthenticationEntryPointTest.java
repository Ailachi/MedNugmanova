package kz.iitu.itse1909r.nugmanova.Security;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class AuthenticationEntryPointTest {
    AuthenticationEntryPoint authenticationEntryPoint = new AuthenticationEntryPoint();

    @Test
    void testAfterPropertiesSet() {
        authenticationEntryPoint.afterPropertiesSet();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme