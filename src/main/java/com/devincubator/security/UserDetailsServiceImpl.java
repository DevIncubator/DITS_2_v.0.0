package com.devincubator.security;//package com.devincubator.security;

import com.devincubator.entity.Role;
import com.devincubator.entity.User;
import com.devincubator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Aunthification service
 *
 * @author Alex V.
 */


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        Role role = user.getRole();
        String userRole;
        if (role.isAdmin()) {
            userRole = "ADMIN";
        } else if (role.isTutor()) {
            userRole = "TUTOR";
        } else userRole = "USER";

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE" + userRole);
        grantedAuthorities.add(authority);

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }
}