package com.devincubator.service;

import com.devincubator.entity.Role;

import java.util.List;

/**
 * Created by Dmitry on 05.03.2018.
 */
public interface RoleService {

    public List<Role> getAll();

    public Role create(Role role);
}
