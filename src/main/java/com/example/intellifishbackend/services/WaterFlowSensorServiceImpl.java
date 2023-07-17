package com.example.intellifishbackend.services;

import com.example.intellifishbackend.MQTT.dtos.WaterFlowSensorDataBodyRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.entities.WaterFlowSensor;
import com.example.intellifishbackend.entities.WaterTemperatureSensor;
import com.example.intellifishbackend.repositories.IWaterFlowSensorRepository;
import com.example.intellifishbackend.services.interfaces.IWaterFlowSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WaterFlowSensorServiceImpl implements IWaterFlowSensorService {

    @Autowired
    private IWaterFlowSensorRepository repository;
    @Override
    public void create(WaterFlowSensorDataBodyRequest request) {

        repository.save(from(request));
    }

    @Override
    public BaseResponse list() {

        List<WaterFlowSensor> data = repository.findAll();

        List<String> dataColumn = data.stream()
                .map(WaterFlowSensor::getAverage)
                .toList();

        return BaseResponse.builder()
                .data(dataColumn)
                .message("Data found successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();

    }


    private WaterFlowSensor from(WaterFlowSensorDataBodyRequest request){
        WaterFlowSensor waterFlowSensor = new WaterFlowSensor();
        waterFlowSensor.setMeasure(request.getMeasure());
        waterFlowSensor.setAverage(request.getAverage());
        waterFlowSensor.setVariance(request.getVariance());
        waterFlowSensor.setStandardDeviation(request.getStandardDeviation());
        waterFlowSensor.setMeanDeviation(request.getMeanDeviation());

        return waterFlowSensor;
    }
}
