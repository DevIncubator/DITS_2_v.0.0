package entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "literature")
public class Literature {

    @Id
    @Column(name = "literatureId")
    private int literatureId;

    @Column(name = "description")
    private String description;

    @Column(name = "questionId")
    @JoinColumn(referencedColumnName = "questionId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Question questionId;

    public int getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(int literatureId) {
        this.literatureId = literatureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }
}
