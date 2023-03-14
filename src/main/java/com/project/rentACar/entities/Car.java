package com.project.rentACar.entities;

import com.project.rentACar.enums.EnumVehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name="car")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(length = 50)
    private String name;
    @Column(name = "state")
    private Enum state;
    @Column(name = "plates" , unique = true)
    private String plates;
    @Column(name = "daily_price")
    private double dailyPrice;
    @Column(name = "model_year")
    private int modelYear;
    @Column(name = "seats",length = 1)
    private int seats;
    @Column(name ="manuel_auto")
    private boolean manuelAuto;
    @Column(name="vehicle_type")
    private EnumVehicleType enumVehicleType;
    @Column(name="creat_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;



}
