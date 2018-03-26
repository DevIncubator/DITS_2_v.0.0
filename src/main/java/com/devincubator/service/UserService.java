package com.devincubator.service;

import com.devincubator.dto.UserDTO;
import com.devincubator.entity.User;

import java.util.List;

/**
 * Created by Dmitry on 05.03.2018.
 */
public interface UserService {

    public List<User> getAll();

    public User create(UserDTO user);
}
