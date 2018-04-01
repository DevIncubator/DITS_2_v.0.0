package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "answer")
public class Answer implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerId")
    private Long answerId;

    @Column(name = "description")
    private String description;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", description='" + description + '\'' +
                ", correct=" + correct +
                ", question=" + question +
                '}';
    }
}
