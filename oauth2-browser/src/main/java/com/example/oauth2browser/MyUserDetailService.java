package com.example.oauth2browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 处理用户信息获取逻辑
     * 通过实现 UserDetailsService 接口并且实现 loadUserByUsername 方法实现从数据源获取用户数据和权限信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户名: {}",username);
//        根据用户查找用户信息
        String password = passwordEncoder.encode("123456");
        log.info("从数据库读取的密码是: {}",password);
        /*
        用户校验逻辑是通过userdetails 的一些方法进行设置值然后被框架本身校验，分别如下：
            boolean isAccountNonExpired();  账户未过期
            boolean isAccountNonLocked();   账户未被锁定
            boolean isCredentialsNonExpired();  密码未过期
            boolean isEnabled();    账户可用
            任何一项设设置成false都将不通过认证。返回的对象可以是springsecurity提供的user对象，也可以是任意的自定义的实现了UserDetails的对象
            user对象还有一个构造方法，可以直接用来设置用户逻辑校验
            public User(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
			对于不通过的地方填false就行了
         */
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
