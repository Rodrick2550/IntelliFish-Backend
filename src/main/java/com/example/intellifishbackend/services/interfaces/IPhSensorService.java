package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.MQTT.dtos.PhSensorDataBodyRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;

public interface IPhSensorService {

    void create(PhSensorDataBodyRequest request);

     BaseResponse list();

    String[] findLastDataFromAverage();

    String [] findLastDataFromMeanDeviation();

    String [] findLastDataFromMeasure();

    String []  findLastDataFromStandardDeviation();

    String [] findLastDataFromVariance();

}
