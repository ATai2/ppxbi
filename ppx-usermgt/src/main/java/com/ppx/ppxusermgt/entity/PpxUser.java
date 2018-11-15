package com.ppx.ppxusermgt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "ppx_user")
public class PpxUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column(length = 32)
    private String userName;
    @Column(length = 32)
    @JsonIgnore
    private String pwd;
    private String role;

}
