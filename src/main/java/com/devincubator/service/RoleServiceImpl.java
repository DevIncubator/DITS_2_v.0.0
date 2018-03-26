package com.devincubator.service;

import com.devincubator.entity.Role;
import com.devincubator.enums.Roles;
import com.devincubator.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dmitry on 05.03.2018.
 */
@Service
@Transactional
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

    @Override
    public Role getByRole(String role) {
        return roleRepository.findByRole(Roles.valueOf(role));
    }
}
