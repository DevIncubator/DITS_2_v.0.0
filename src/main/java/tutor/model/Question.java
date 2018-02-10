package tutor.model;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Entity with JPA annotations
 * Hibernate provides JPA implementation
 *
 * @author Alex V.
 */
@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @Column(name = "questionId")
    private int questionId;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "testId", nullable = false)
    private Test test;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
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