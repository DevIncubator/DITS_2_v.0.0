package com.devincubator.repository;

import com.devincubator.entity.Role;
import com.devincubator.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitry on 05.03.2018.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(Roles role);
}
