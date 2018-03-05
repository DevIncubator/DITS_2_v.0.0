package com.devincubator.dto;

/**
 * Created by Dmitry on 05.03.2018.
 */
public enum UserRoleDTO {

    ADMIN("admin"),
    TUTOR("tutor"),
    USER("user");

    private String name;

    UserRoleDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
