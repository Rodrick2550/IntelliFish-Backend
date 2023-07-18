package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.MQTT.dtos.WaterFlowSensorDataBodyRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;

public interface IWaterFlowSensorService {

    void create(WaterFlowSensorDataBodyRequest request);

    BaseResponse list();

    String findLastDataFromAverage();

    String findLastDataFromMeanDeviation();

    String findLastDataFromMeasure();

    String findLastDataFromStandardDeviation();

    String findLastDataFromVariance();
}
