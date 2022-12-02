package com.br.shopcar.ConfigSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment env;
    @Autowired
    private JwtTokenStore tokenStore;

    private static final String[] PUBLIC = {"/oauth/token","/api/v1/announce/cars/**","api/v1/comment","/api/v1/announce/*"};

    private static final String[] OTHER = {"/api/v1/announce/cars/filters","/api/v1/announce/cars/filters/**"};
    private static final String[] ADMIN = {"/api/v1/announce/**","api/v1/comment/**","api/v1/user/**"};
    private static final String[] USER = {"api/v1/user", "/api/v1/announce/**","api/v1/comment/**","api/v1/comment/answer/**"};

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if(Arrays.asList(env.getActiveProfiles()).contains("test")){
            http.headers().frameOptions().disable();
        }
        http.authorizeRequests()
                //public
                .antMatchers(HttpMethod.GET, PUBLIC).permitAll()
                //filter
                .antMatchers(HttpMethod.POST,OTHER).permitAll()
                .antMatchers(HttpMethod.GET,OTHER).permitAll()
                //user
                .antMatchers(HttpMethod.GET, USER).hasRole("USER")
                .antMatchers(HttpMethod.POST, USER).hasRole("USER")
                .antMatchers(HttpMethod.PUT, USER).hasRole("USER")
                //admin
                .antMatchers(HttpMethod.DELETE, USER).hasRole("ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}
