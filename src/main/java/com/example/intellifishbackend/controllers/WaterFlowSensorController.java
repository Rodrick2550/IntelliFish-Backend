package com.example.intellifishbackend.controllers;

import com.example.intellifishbackend.services.interfaces.IWaterFlowSensorService;
import com.example.intellifishbackend.services.interfaces.IWaterTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/waterflowsensor")
public class WaterFlowSensorController {

    @Autowired
    private IWaterFlowSensorService service;

    @GetMapping("average")
    public ResponseEntity<String> findLastDataFromAverage(){

        String lastData = service.findLastDataFromAverage();

        return ResponseEntity.ok(lastData);

    }

    @GetMapping("meanDeviation")
    public ResponseEntity<String> findLastDataFromMeanDeviation(){

        String lasData = service.findLastDataFromMeanDeviation();

        return ResponseEntity.ok(lasData);
    }

    @GetMapping("measure")
    public ResponseEntity<String> findLastDataFromMeasure(){

        String lasData = service.findLastDataFromMeasure();

        return ResponseEntity.ok(lasData);

    }

    @GetMapping("standardDeviation")
    public ResponseEntity<String> findLastDataFromStandardDeviation(){

        String lasData = service.findLastDataFromStandardDeviation();

        return ResponseEntity.ok(lasData);
    }

    @GetMapping("variance")
    public ResponseEntity<String> findLastDataFromVariance(){

        String lasData = service.findLastDataFromVariance();

        return ResponseEntity.ok(lasData);
    }
}
