//package com.dev_incubator.dits.persistence.entity;
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
//public class Literature {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String description;
//    @ManyToOne
//    private Set<Link> links = new HashSet<>();
//    @OneToMany
//    private Question question;
//}
