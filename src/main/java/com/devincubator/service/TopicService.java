package com.devincubator.service;

import com.devincubator.entity.Topic;

import java.util.List;

/**
 * Created by Dmitry on 25.02.2018.
 */
public interface TopicService {

    public List<Topic> getAll();

    public Topic create(Topic topic);

    Topic findByName(String name);
}
