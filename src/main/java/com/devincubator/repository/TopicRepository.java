package com.devincubator.repository;

import com.devincubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmitry on 25.02.2018.
 */
@Repository
public interface TopicRepository extends JpaRepository <Topic, Integer> {

    Topic findByName(String name);

}
