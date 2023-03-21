package com.project.rentACar.entities;

import com.project.rentACar.enums.EnumState;
import com.project.rentACar.enums.EnumVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name = "Cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "state")
    private EnumState state;
    @Column(name = "plates" , unique = true)
    private String plates;
    @Column(name = "daily_price")
    private double dailyPrice;
    @Column(name = "model_year")
    private int modelYear;
    @Column(name = "seats")
    private int seats;
    @Column(name ="manuel_auto")
    private boolean manuelAuto;
    @Column(name="vehicle_type")
    private EnumVehicleType enumVehicleType;
    @Column(name="creat_date")
    private LocalDateTime createDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;



}
