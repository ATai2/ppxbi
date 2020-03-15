package com.ppx.ppxusermgt.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ppx_user")
public class PpxUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column(length = 32, nullable = false)
    private String userName;
    @Column(length = 32, nullable = false)
    private String pwd;
    private String role;

}
