package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "topic")
public class Topic implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topicId")
    private Long topicId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic() {
    }

    public Topic(String topicName) {
        this.name = topicName;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
