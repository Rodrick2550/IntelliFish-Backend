package com.example.intellifishbackend.controllers;

import com.example.intellifishbackend.services.interfaces.IWaterTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/watertemperaturesensor")
public class WaterTemperatureSensorController {

    @Autowired
    private IWaterTemperatureService service;

    @GetMapping("average")
    public String [] findLastDataFromAverage(){

        String lastData []= service.findLastDataFromAverage();

        return lastData;

    }

    @GetMapping("meanDeviation")
    public  String [] findLastDataFromMeanDeviation(){

        String lasData [] = service.findLastDataFromMeanDeviation();

        return lasData;
    }

    @GetMapping("measure")
    public String []findLastDataFromMeasure(){

        String lasData [] = service.findLastDataFromMeasure();

        return lasData;

    }

    @GetMapping("standardDeviation")
    public String [] findLastDataFromStandardDeviation(){

        String lasData [] = service.findLastDataFromStandardDeviation();

        return lasData;
    }

    @GetMapping("variance")
    public String [] findLastDataFromVariance(){

        String lasData [] = service.findLastDataFromVariance();

        return lasData;
    }
}
