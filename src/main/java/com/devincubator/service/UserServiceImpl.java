package com.devincubator.service;

import com.devincubator.dto.UserDTO;
import com.devincubator.entity.User;
import com.devincubator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * Created by Dmitry on 05.03.2018.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleServiceImpl roleService;

    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(roleService.getByRole(userDTO.getRole()));
        return userRepository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
