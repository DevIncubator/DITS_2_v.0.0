package entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Dmitry on 08.02.2018.
 */
@Entity
@Table(name = "role")
public class Role implements entity.Entity {
    @Id
    @GeneratedValue
    @Column(name = "roleId", nullable = false)
    private int roleId;

    @Column(name = "user")
    private boolean user;

    @Column(name = "tutor")
    private boolean tutor;

    @Column(name = "admin")
    private boolean admin;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public boolean isTutor() {
        return tutor;
    }

    public void setTutor(boolean tutor) {
        this.tutor = tutor;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}