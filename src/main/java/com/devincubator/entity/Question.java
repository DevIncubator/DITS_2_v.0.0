package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Entity with JPA annotations
 * Hibernate provides JPA implementation
 *
 * @author Alex V.
 */
@Entity
@Table(name = "question")
public class Question implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private Long questionId;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "testId")
    private Test test;

    public Question(String description) {
        this.description = description;
    }
    public Question(){}
    public Question(String description, Test test){
        this.description = description;
        this.test = test;
    }


    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                ", test=" + test +
                '}';
    }
}