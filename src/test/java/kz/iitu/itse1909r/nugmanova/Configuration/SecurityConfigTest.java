package kz.iitu.itse1909r.nugmanova.Configuration;

import kz.iitu.itse1909r.nugmanova.Security.AuthenticationEntryPoint;
import kz.iitu.itse1909r.nugmanova.Service.UserDetailsServiceImpl;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.accept.ContentNegotiationStrategy;

import static org.mockito.Mockito.*;

class SecurityConfigTest {
    @Mock
    AuthenticationEntryPoint authenticationEntryPoint;
    @Mock
    Log logger;
    @Mock
    ApplicationContext context;
    @Mock
    ContentNegotiationStrategy contentNegotiationStrategy;
    @Mock
    ObjectPostProcessor<Object> objectPostProcessor;
    @Mock
    AuthenticationConfiguration authenticationConfiguration;
    @Mock
    AuthenticationManagerBuilder authenticationBuilder;
    @Mock
    AuthenticationManagerBuilder localConfigureAuthenticationBldr;
    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    AuthenticationTrustResolver trustResolver;
    //Field http of type HttpSecurity - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    SecurityConfig securityConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testPasswordEncoder() {
        PasswordEncoder result = securityConfig.passwordEncoder();
        Assertions.assertNotNull(result);
    }

    @Test
    void testUserDetailsService() {
        UserDetailsService result = securityConfig.userDetailsService();
        Assertions.assertNotNull(result);
    }

    @Test
    void testHttpSessionEventPublisher() {
        HttpSessionEventPublisher result = securityConfig.httpSessionEventPublisher();
        Assertions.assertNotNull(result);
    }

}