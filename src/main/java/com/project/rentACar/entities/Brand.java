package com.project.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Table(name="brand")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}
