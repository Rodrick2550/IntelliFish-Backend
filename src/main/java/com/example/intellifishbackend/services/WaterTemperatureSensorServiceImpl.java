package com.example.intellifishbackend.services;

import com.example.intellifishbackend.MQTT.dtos.WaterTemperatureSensorDataBodyRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.entities.WaterTemperatureSensor;
import com.example.intellifishbackend.repositories.IWaterTemperatureSensorRepository;
import com.example.intellifishbackend.services.interfaces.IWaterTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WaterTemperatureSensorServiceImpl implements IWaterTemperatureService {

    @Autowired
    private IWaterTemperatureSensorRepository repository;

    @Override
    public void create(WaterTemperatureSensorDataBodyRequest request) {

        repository.save(from(request));
    }

    @Override
    public BaseResponse list() {

        List<WaterTemperatureSensor> data = repository.findAll();

        List<String> dataColumn = data.stream()
                .map(WaterTemperatureSensor::getAverage)
                .toList();

        return BaseResponse.builder()
                .data(dataColumn)
                .message("Data found successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private WaterTemperatureSensor from(WaterTemperatureSensorDataBodyRequest request){
        WaterTemperatureSensor waterTemperatureSensor = new WaterTemperatureSensor();

        waterTemperatureSensor.setMeasure(request.getMeasure());
        waterTemperatureSensor.setAverage(request.getAverage());
        waterTemperatureSensor.setVariance(request.getVariance());
        waterTemperatureSensor.setStandardDeviation(request.getStandardDeviation());
        waterTemperatureSensor.setMeanDeviation(request.getMeanDeviation());

        return waterTemperatureSensor;
    }
}
