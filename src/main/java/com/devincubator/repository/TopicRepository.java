package com.devincubator.repository;

import com.devincubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitry on 25.02.2018.
 */
public interface TopicRepository extends JpaRepository<Topic, Long> {

    Topic findByName(String name);

}
