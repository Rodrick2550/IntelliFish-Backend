package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.controllers.dtos.requests.CreatePlantRequest;
import com.example.intellifishbackend.controllers.dtos.requests.UpdatePlantRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.entities.Plant;
import org.springframework.stereotype.Service;


public interface IPlantService {

    BaseResponse get (Long id);

    BaseResponse create (CreatePlantRequest request);

    BaseResponse update (Long id, UpdatePlantRequest request);

    BaseResponse delete (Long id);

    BaseResponse list (Long userId);

    Plant findOneAndEnsureExistById(Long id);
}
