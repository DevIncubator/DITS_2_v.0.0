package com.devincubator.service;

import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;
import com.devincubator.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    /*public List<Test> findByTopicId(Topic topicId) {
        return testRepository.findByTopicId(topicId);
    }*/

    @Override
    public Test create(Test test) {
        return testRepository.save(test);
    }

    public List<Test> findByTopic(Topic topic) {
        return testRepository.findByTopic(topic);
    }

    public Test findByName(String name) {return testRepository.findByName(name);}
}
