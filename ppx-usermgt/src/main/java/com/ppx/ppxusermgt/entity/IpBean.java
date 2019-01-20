package com.ppx.ppxusermgt.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table(name="ippool")
@Entity
public class IpBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String ip;
    @Column
    private String port;
    @Column
    private String hide;
    @Column
    private String type;
    @Column
    private String status;
    @Column
    private String location;
    @Column(name = "respSpeed")
    private String respSpeed;
    @Column(name = "lastVeryfyTime")
    private String lastVeryfyTime;
}
