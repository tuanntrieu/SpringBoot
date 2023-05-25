package com.example.codebuoi9.service;

import com.example.codebuoi9.model.User;
import com.example.codebuoi9.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        GrantedAuthority grantedAuthorities = (GrantedAuthority) user.getRole();
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException(String.format("User with username : %s not found ", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), (Collection<? extends GrantedAuthority>) grantedAuthorities);
    }

}
