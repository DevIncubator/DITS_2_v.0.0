package com.devincubator.repository;

import com.devincubator.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmitry on 05.03.2018.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
