//package com.dev_incubator.dits.persistence.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//public class Statistic {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private LocalDateTime date;
//    private Integer correct;
//    @OneToMany
//    private User user;
//    @OneToMany
//    private Question question;
//}
