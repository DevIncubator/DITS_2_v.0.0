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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statisticId")
    private Long statisticId;

    @Column(name = "date")
    private Date date;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Statistic(User user, Question question, Date date, boolean correct){
        this.question = question;
        this.correct = correct;
        this.date = date;
        this.user = user;
    }

    public Statistic(){}

    public Long getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(Long statisticId) {
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