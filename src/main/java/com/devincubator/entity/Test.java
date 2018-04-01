package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "test")
public class Test implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testId")
    private Long testId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "topicId", nullable = false)
    private Topic topic;

    public Test() {
    }

    public Test(Long testId, String name, String description) {
        this.testId = testId;
        this.name = name;
        this.description = description;
    }

    public Test(String name, Topic topic) {
        this.topic = topic;
        this.name = name;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", topic=" + topic +
                '}';
    }
}

