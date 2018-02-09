package user.model;

import javax.persistence.*;

@Entity
@Table(name = "link")
public class Link {

    @Id
    @Column(name = "linkId")
    private int linkId;

    @Column(name = "link")
    private String link;

    @Column(name = "literatureId")
    @JoinColumn(referencedColumnName = "literatureId")
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
