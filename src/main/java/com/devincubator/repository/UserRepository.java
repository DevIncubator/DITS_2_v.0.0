package com.devincubator.repository;

import com.devincubator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmitry on 05.03.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM User u WHERE u.login = :login")
    User findByLogin(String login);

}
