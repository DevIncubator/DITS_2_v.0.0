package com.devincubator.service;

import com.devincubator.entity.User;
import com.devincubator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
