package com.example.intellifishbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "waterflowsensor")
@Getter
@Setter
public class WaterFlowSensor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    @Column()
    private Float variance;
    
    @Column()
    private Float standardDeviation;

    @Column()
    private Float meanDeviation;
}
