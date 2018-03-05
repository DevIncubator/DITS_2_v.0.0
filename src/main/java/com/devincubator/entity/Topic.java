package com.devincubator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic implements com.devincubator.entity.Entity {

    @Id
    @Column(name = "topicId")
    private int topicId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
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

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
