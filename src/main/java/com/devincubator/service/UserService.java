package com.devincubator.service;

import com.devincubator.dto.UserDTO;
import com.devincubator.entity.User;

import java.util.List;

/**
 * Created by Dmitry on 05.03.2018.
 */
public interface UserService {

     List<User> getAll();

     User create(UserDTO user);

     User findByLogin(String login);
}
