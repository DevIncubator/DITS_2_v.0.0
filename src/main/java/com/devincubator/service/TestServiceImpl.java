package com.devincubator.service;

import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;
import com.devincubator.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Dmitry on 26.02.2018.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Test create(Test test) {
        return testRepository.save(test);
    }

    public List<Test> findByTopicId(Topic topicId) {
        return testRepository.findByTopicId(topicId);
    }
}
