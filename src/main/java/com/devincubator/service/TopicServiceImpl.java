package com.devincubator.service;

import com.devincubator.entity.Topic;
import com.devincubator.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitry on 25.02.2018.
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Topic> getAll() {
        return topicRepository.findAll();
    }

    @Override
    public Topic create(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic findByName(String name) {
        return topicRepository.findByName(name);
    }

}
