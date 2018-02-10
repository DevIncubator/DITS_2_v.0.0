package entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "link")
public class Link {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "linkId")
    private int linkId;

    @Column(name = "link")
    private String link;

    @Column(name = "literatureId")
    @PrimaryKeyJoinColumn
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Literature literatureId;

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Literature getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(Literature literatureId) {
        this.literatureId = literatureId;
    }
}
