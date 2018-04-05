package com.devincubator.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "link")
public class Link implements com.devincubator.entity.Entity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "linkId")
    private Long linkId;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "literatureId")
    private Literature literature;

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", link='" + link + '\'' +
                ", literature=" + literature +
                '}';
    }

}
