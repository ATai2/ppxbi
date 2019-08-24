package com.ppx.common.message.ppxshiro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String permission;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}