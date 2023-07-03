package com.example.intellifishbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "watertemperaturesensor1")
@Getter
@Setter
public class WaterTemperatureSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column()
    private Float value;

    @Column()
    private String measure;
}
