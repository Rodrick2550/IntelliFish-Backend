package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.WaterTemperatureSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IWaterTemperatureSensorRepository extends JpaRepository<WaterTemperatureSensor, Long> {

    @Query(value = "select watertemperaturesensor.average from watertemperaturesensor "+
            "order by average DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromAverage();

    @Query(value = "select watertemperaturesensor.mean_deviation from watertemperaturesensor "+
            "order by mean_deviation DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromMeanDeviation();

    @Query(value = "select watertemperaturesensor.measure from watertemperaturesensor "+
            "order by measure DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromMeasure();

    @Query(value = "select watertemperaturesensor.standard_deviation from watertemperaturesensor "+
            "order by standard_deviation DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromStandardDeviation();

    @Query(value = "select watertemperaturesensor.variance from watertemperaturesensor "+
            "order by variance DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromVariance();

}
