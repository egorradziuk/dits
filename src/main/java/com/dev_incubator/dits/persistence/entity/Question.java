package com.dev_incubator.dits.persistence.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//public class Question {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String description;
//    @ManyToOne
//    private Set<Answer> answers = new HashSet<>();
//    @OneToMany
//    private Test test;
//    @ManyToOne
//    private Set<Literature> literatures = new HashSet<>();
//}

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private Test test;

    /*@OneToMany(mappedBy = "question")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answer;

    @OneToMany(mappedBy = "question")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Statistic> statistics;

    //todo change to oneToMany
    @OneToOne(mappedBy = "question", fetch = FetchType.EAGER)
    private Literature literature;*/

}