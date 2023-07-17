package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.WaterFlowSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWaterFlowSensorRepository extends JpaRepository<WaterFlowSensor, Long> {
}
