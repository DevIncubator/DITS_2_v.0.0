package com.devincubator.service;

import com.devincubator.entity.Topic;

import java.util.List;

/**
 * Created by Dmitry on 25.02.2018.
 */
public interface TopicService {

    List<Topic> getAll();

    Topic create(Topic topic);

    Topic findByTopicId(Long topicId);

    Topic findByName(String name);

}
