package com.toltek.springbootapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column (name = "age")
    private  int age;
}
