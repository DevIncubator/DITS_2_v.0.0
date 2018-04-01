package com.devincubator.service;

import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;

import java.util.List;

public interface TestService {

    public List<Test> getAll();

    public Test create(Test test);

    public List<Test> findByTopic(Topic topic);

    public Test findByName(String name);

    public List<Test> findByTopicId(Long topicId);

}
