package com.devincubator.service;

import com.devincubator.entity.Test;

import java.util.List;

/**
 * Created by Dmitry on 26.02.2018.
 */
public interface TestService {

    public List<Test> getAll();

    public Test create(Test test);

    public List<Test> findByTopicId(int topicId);

}
