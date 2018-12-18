package com.muke.security.mukesecuritybrowsers.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        //自己的加密方法，实现他的方法返回 自己的加密数据
      return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //任何请求 都要进行表单登录
       http.formLogin()
        //http.httpBasic()//basic方式登录
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated();
    }
}
