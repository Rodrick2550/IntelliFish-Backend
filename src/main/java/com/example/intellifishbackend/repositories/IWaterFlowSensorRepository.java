package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.WaterFlowSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IWaterFlowSensorRepository extends JpaRepository<WaterFlowSensor, Long> {

    @Query(value = "select waterflowsensor.average from waterflowsensor "+
            "order by average DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromAverage();

    @Query(value = "select waterflowsensor.mean_deviation from waterflowsensor "+
            "order by mean_deviation DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromMeanDeviation();

    @Query(value = "select waterflowsensor.measure from waterflowsensor "+
            "order by measure DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromMeasure();

    @Query(value = "select waterflowsensor.standard_deviation from waterflowsensor "+
            "order by standard_deviation DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromStandardDeviation();

    @Query(value = "select waterflowsensor.variance from waterflowsensor "+
            "order by variance DESC LIMIT 15",nativeQuery = true)
    String [] findLastDataFromVariance();
}
