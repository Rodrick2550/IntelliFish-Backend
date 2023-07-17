package com.example.intellifishbackend.services;

import com.example.intellifishbackend.MQTT.dtos.PhSensorDataBodyRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.controllers.exceptions.ObjectNotFoundException;
import com.example.intellifishbackend.entities.PhSensor;
import com.example.intellifishbackend.repositories.IPhSensorRepository;
import com.example.intellifishbackend.services.interfaces.IPhSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhSensorServiceImpl implements IPhSensorService {

    @Autowired
    private IPhSensorRepository repository;

    @Override
    public void create(PhSensorDataBodyRequest request) {

        repository.save(from(request));
    }

    @Override
    public BaseResponse list() {
        List<PhSensor> data = repository.findAll();

        List<String> dataColumn =data.stream()
                .map(PhSensor::getAverage)
                .toList();


        return BaseResponse.builder()
                .data(dataColumn)
                .message("Data found successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }




    private PhSensor from(PhSensorDataBodyRequest request){
        PhSensor phSensor = new PhSensor();
        phSensor.setMeasure(request.getMeasure());
        phSensor.setAverage(request.getAverage());
        phSensor.setVariance(request.getVariance());
        phSensor.setStandardDeviation(request.getStandardDeviation());
        phSensor.setMeanDeviation(request.getMeanDeviation());

        return phSensor;

    }


}
