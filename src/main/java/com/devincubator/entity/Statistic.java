package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Dmitry on 06.02.2018.
 */

@Entity
@Table(name = "statistic")
public class  Statistic {

    @Id
    @GeneratedValue
    @Column(name = "statisticId", nullable = false)
    private int statisticId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public int getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(int statisticId) {
        this.statisticId = statisticId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}