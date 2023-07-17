package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.MQTT.dtos.PhSensorDataBodyRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.entities.PhSensor;

public interface IPhSensorService {

    void create(PhSensorDataBodyRequest request);

     BaseResponse list();



}
