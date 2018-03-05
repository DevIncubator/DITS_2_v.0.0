package com.devincubator.dto;

import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;

/**
 * Created by Dmitry on 05.03.2018.
 */
public class TopicTestDTO {

    private Topic topic;
    private Test test;

    TopicTestDTO() {
    }

    public TopicTestDTO(Topic topic, Test test) {
        this.topic = topic;
        this.test = test;
    }


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
