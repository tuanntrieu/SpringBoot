package com.example.buoi9.config;

import com.example.buoi9.service.UserDetailServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v1/user/**").hasAuthority("ROLE_USER")
                .antMatchers("/api/v1/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()// 1 loại tấn công bảo mật sử dụng yêu cầu từ trang web khác
                .cors().disable();//Chính sách bảo mật trong tình duyệt web kiểm soat chia sẻ tài nguyên giữa các nguôn
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //tạo 1 đối tượng UserDetailService và quản lý nó trong SpringContext
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImp();
    }

    //Cấu hình AuthenticationManager xử lý quá trình authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
}
