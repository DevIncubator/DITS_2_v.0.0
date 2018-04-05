package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "literature")
public class Literature implements com.devincubator.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "literatureId")
    private Long literatureId;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public Long getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(Long literatureId) {
        this.literatureId = literatureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Literature{" +
                "literatureId=" + literatureId +
                ", description='" + description + '\'' +
                ", question=" + question +
                '}';
    }
}
