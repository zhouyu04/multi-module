package com.zzyy.rs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
        http://docs.spring.io/spring-security/site/docs/current/guides/html5//hellomvc-javaconfig.html
        http://docs.spring.io/spring/docs/4.3.3.BUILD-SNAPSHOT/spring-framework-reference/htmlsingle/#mvc-config-enable
        https://github.com/Robbert1/boot-stateless-auth/blob/master/src/main/java/com/jdriven/stateless/security/StatelessAuthenticationSecurityConfig.java
    */
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    SystemAuthenticationFailureHandler systemAuthenticationFailureHandler;

    @Autowired
    SystemAuthenticationSuccessHandler systemAuthenticationSuccessHandler;

    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Autowired
    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    public void configureGlobal(
            AuthenticationManagerBuilder auth) throws Exception {
        // 自定义UserDetailsService
        auth.userDetailsService(userDetailsService).passwordEncoder(
                new CustomMessageDigestPasswordEncoder("SHA-256"));
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/security_check")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login?error")
                .loginPage("/login")
                .permitAll()
                .failureHandler(systemAuthenticationFailureHandler)
                .successHandler(systemAuthenticationSuccessHandler);


        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true).logoutSuccessHandler(customLogoutSuccessHandler);

        http.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);


        http.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint);

        http.sessionManagement().maximumSessions(2).sessionRegistry(sessionRegistry());

    }


}
