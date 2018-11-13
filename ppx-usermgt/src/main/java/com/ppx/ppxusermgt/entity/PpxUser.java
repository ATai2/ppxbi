package com.ppx.ppxusermgt.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "ppxUser")
public class PpxUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "pwd")
    private String pwd;
    private String role;

}
