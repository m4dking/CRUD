package net.example.springbootdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "organization")
    private String organization;
    @Column(name = "adress")
    private String adress;
    @Column(name = "person")
    private String person;
    @Column(name = "number")
    private String number;
    @Column(name = "manager")
    private String manager;
    @Column(name = "contract")
    private String contract;
    @Column(name = "actfirst")
    private String actfirst;
    @Column(name = "actlast")
    private String actlast;
}
