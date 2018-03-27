package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Dmitry on 27.03.2018.
 */

@Entity
@Table(name = "question_statistic")
public class QuestionStatistic implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "all_answers")
    private int sumAnswers;

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

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public int getSumAnswers() {
        return sumAnswers;
    }

    public void setSumAnswers(int sumAnswers) {
        this.sumAnswers = sumAnswers;
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
