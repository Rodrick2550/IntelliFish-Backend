package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.WaterTemperatureSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWaterTemperatureSensorRepository extends JpaRepository<WaterTemperatureSensor, Long> {
}
