package com.muke.security.mukesecuritybrowsers.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class MyUserDetailService implements UserDetailsService {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          logger.info("登录的用户名为"+username);
          //根据用户名查找用户信息,1用户名2，2密码，3权限
        String encode = passwordEncoder.encode("123456");//把密码进行加密，模拟，一般申请时候密码
        return new User(username,encode,
                true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
