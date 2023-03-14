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
@Entity(name = "Brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}
