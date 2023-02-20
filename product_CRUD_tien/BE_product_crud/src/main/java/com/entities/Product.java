package com.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name",columnDefinition="VARCHAR(128)",unique=true)
    private String name;

    @ManyToOne
    private Category category;

    @Column(name = "img",columnDefinition="LONGTEXT")
    private String img;

    @Column(name = "price")
    private double price;

    @Column(name = "created_at")
    private Date created_at;


}
