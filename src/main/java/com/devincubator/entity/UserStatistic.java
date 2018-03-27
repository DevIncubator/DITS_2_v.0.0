package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Dmitry on 26.03.2018.
 */
@Entity
@Table(name = "user_statistic")
public class UserStatistic implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "fio")
    private String fio;

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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getsumAnswers() {
        return sumAnswers;
    }

    public void setsumAnswers(int sumQuestion) {
        this.sumAnswers = sumQuestion;
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
