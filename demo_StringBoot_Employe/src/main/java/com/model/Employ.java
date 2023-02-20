package com.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Employ {
    @Id
    private String id;
    private String name;
    private int age;

    @ManyToOne
    private Department department;

}
