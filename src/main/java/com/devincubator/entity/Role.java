package com.devincubator.entity;

import com.devincubator.enums.Roles;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "role")
public class Role implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId", nullable = false)
    private int roleId;

    @Enumerated(EnumType.STRING)
    private Roles role;


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}