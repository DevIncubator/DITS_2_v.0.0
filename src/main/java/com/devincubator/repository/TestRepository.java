package com.devincubator.repository;

import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

//    @Query("select b from test b where b.topicId = :topicId")
    //List<Test> findByTopicId(@Param("topicId") Topic topic);
}
