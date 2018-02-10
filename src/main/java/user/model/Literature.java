package user.model;

import javax.persistence.*;

public class Literature {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "literatureId")
    private int literatureId;

    @Column(name = "description")
    private String description;

    @Column(name = "questionId")
    @PrimaryKeyJoinColumn
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
