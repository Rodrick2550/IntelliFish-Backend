package com.example.intellifishbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "watertemperaturesensor")
@Getter
@Setter
public class WaterTemperatureSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String measure;

    @Column()
    private String variance;

    @Column
    private String average;

    @Column()
    private String standardDeviation;

    @Column()
    private String meanDeviation;
}
