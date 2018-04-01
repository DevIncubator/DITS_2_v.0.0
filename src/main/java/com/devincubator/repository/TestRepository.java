package com.devincubator.repository;

import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findByTopic(Topic topic);

    Test findByName(String name);

    //List<Test> findByTopicId(Topic topicId);



}
