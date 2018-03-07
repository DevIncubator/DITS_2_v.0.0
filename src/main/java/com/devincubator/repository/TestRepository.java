package com.devincubator.repository;

import com.devincubator.entity.Test;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitry on 26.02.2018.
 */
public interface TestRepository extends JpaRepository<Test, Long> {
=======
import com.devincubator.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

//    @Query("select b from test b where b.topicId = :topicId")
    List<Test> findByTopicId(@Param("topicId") Topic topic);

>>>>>>> master
}
