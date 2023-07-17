package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.PhSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhSensorRepository extends JpaRepository<PhSensor, Long> {

    @Query(value = "SELECT average FROM phsensor ORDER BY average.id DESC ")
    String findLastDataFromAverage();
}
