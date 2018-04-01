package com.devincubator.service;

import com.devincubator.entity.Topic;

import java.util.List;
import java.util.Optional;

/**
 * Created by Dmitry on 25.02.2018.
 */
public interface TopicService {

    public List<Topic> getAll();

    public Topic create(Topic topic);

    public Topic findByTopicId(Long topicId);

    public Topic findByName(String name);

}
