package user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="user")
public class User {
    @Id
    @Column(name="userId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name="firstName", length = 45)
    private String firstName;

    @Column(name="lastName", length = 45)
    private String lastName;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;



}
