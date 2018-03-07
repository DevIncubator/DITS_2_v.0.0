package com.devincubator.service;

import com.devincubator.entity.Test;
<<<<<<< HEAD
import com.devincubator.repository.TestRepository;
=======
import com.devincubator.entity.Topic;
import com.devincubator.repository.TestRepository;
import com.devincubator.repository.TopicRepository;
>>>>>>> master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

<<<<<<< HEAD
/**
 * Created by Dmitry on 26.02.2018.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;
=======
@Service
public class TestServiceImpl  implements TestService{

    @Autowired
    TestRepository testRepository;
>>>>>>> master

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public Test create(Test test) {
        return testRepository.save(test);
=======
    public List<Test> findByTopicId(Topic topicId) {
        return testRepository.findByTopicId(topicId);
>>>>>>> master
    }
}
