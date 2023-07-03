package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.controllers.dtos.requests.CreateFishRequest;
import com.example.intellifishbackend.controllers.dtos.requests.UpdateFishRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.entities.Fish;

public interface IFishService {

    BaseResponse get (Long id);

    BaseResponse create (CreateFishRequest request);

    BaseResponse update (Long id, UpdateFishRequest request);

    BaseResponse delete (Long id);

    BaseResponse list (Long userId);

    Fish findOneAndEnsureExistById(Long id);
}
