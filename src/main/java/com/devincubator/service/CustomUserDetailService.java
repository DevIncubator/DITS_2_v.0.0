package com.devincubator.service;

import com.devincubator.entity.User;
import com.devincubator.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dmitry on 28.03.2018.
 */
//@Service("customUserDetailService")
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (user != null) {
            List<GrantedAuthority> authorities = buildUserAuthority(user);
            return buildUserFoundAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("User" + username + "not found");
        }
    }

    private List<GrantedAuthority> buildUserAuthority(User user) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        setAuths.add(new SimpleGrantedAuthority(user.getRole().getRole().getName().toUpperCase()));
        List<GrantedAuthority> result = new ArrayList<>(setAuths);
        return result;
    }


    private org.springframework.security.core.userdetails.User buildUserFoundAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }
}
