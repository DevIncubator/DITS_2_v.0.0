package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Dmitry on 19.03.2018.
 */

@Entity
@Table(name = "test_statistic")
public class TestStatistic implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "all_question")
    private int sumQuestion;

    @Column(name = "correct")
    private int sumCorrectQuestion;

    @Column(name = "incorrect")
    private int sumIncorrectQuestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getSumQuestion() {
        return sumQuestion;
    }

    public void setSumQuestion(int sumQuestion) {
        this.sumQuestion = sumQuestion;
    }

    public int getSumCorrectQuestion() {
        return sumCorrectQuestion;
    }

    public void setSumCorrectQuestion(int sumCorrectQuestion) {
        this.sumCorrectQuestion = sumCorrectQuestion;
    }

    public int getSumIncorrectQuestion() {
        return sumIncorrectQuestion;
    }

    public void setSumIncorrectQuestion(int sumIncorrectQuestion) {
        this.sumIncorrectQuestion = sumIncorrectQuestion;
    }
}


