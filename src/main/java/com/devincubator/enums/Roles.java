package com.devincubator.enums;

/**
 * Created by Dmitry on 26.03.2018.
 */
public enum Roles {

    admin("admin"),
    tutor("tutor"),
    user("user");

    private String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "name='" + name + '\'' +
                '}';
    }
}
