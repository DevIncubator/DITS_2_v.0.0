package com.devincubator.service;

import com.devincubator.entity.Role;
import com.devincubator.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Dmitry on 05.03.2018.
 */
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }
}
