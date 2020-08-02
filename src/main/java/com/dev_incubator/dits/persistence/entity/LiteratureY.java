package com.dev_incubator.dits.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Literature")
@Setter
@Getter
public class LiteratureY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    /*@Column(name = "question_id")
    private int questionId;*/


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", insertable=false, updatable=false)
    private QuestionY questionY;

    //todo oneToMany
    @OneToOne(mappedBy = "literatureY", fetch = FetchType.EAGER)
    private LinkY linkY;

    @Override
    public String toString() {
        return "Literature [id = " + id +
                ", description = " + description +
                ", link = " + linkY +
                "]";
    }

}
