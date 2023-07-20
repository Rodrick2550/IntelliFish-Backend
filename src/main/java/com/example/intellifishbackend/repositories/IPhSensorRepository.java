package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.PhSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhSensorRepository extends JpaRepository<PhSensor, Long> {

    @Query(value = "select phsensor.average from phsensor "+
            "order by average DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromAverage();

    @Query(value = "select phsensor.mean_deviation from phsensor "+
            "order by mean_deviation DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromMeanDeviation();

    @Query(value = "select phsensor.measure from phsensor "+
            "order by measure DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromMeasure();

    @Query(value = "select phsensor.standard_deviation from phsensor "+
            "order by standard_deviation DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromStandardDeviation();

    @Query(value = "select phsensor.variance from phsensor "+
            "order by variance DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromVariance();


}
