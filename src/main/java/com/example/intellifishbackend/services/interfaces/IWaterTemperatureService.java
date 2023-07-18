package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.MQTT.dtos.WaterTemperatureSensorDataBodyRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;

public interface IWaterTemperatureService {

    void create(WaterTemperatureSensorDataBodyRequest request);

    BaseResponse list();

    String findLastDataFromAverage();

    String findLastDataFromMeanDeviation();

    String findLastDataFromMeasure();

    String findLastDataFromStandardDeviation();

    String findLastDataFromVariance();
}
