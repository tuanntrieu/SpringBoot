package com.example.baitapbuoi9.services.imp;

import com.example.baitapbuoi9.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailImp implements UserDetails {
    private int id;
    private String fullName;

    private String address;

    private String email;

    private Date birthday;

    private String username;

    private String password;

    Collection<? extends GrantedAuthority> authorities;

    public static UserDetailImp map(User user) {

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().getRoleName().name()));
        return new UserDetailImp(
                user.getId(),
                user.getFullname(),
                user.getAddress(),
                user.getEmail(),
                user.getBirthday(),
                user.getUsername(),
                user.getPassword(),
                roles);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
