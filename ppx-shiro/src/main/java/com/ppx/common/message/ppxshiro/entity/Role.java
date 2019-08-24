package com.ppx.common.message.ppxshiro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private List<Permission> permissions;

}