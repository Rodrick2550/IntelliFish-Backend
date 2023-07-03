package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.controllers.dtos.requests.CreateUserRequest;
import com.example.intellifishbackend.controllers.dtos.requests.UpdateUserRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.entities.User;

public interface IUserService {

    BaseResponse create (CreateUserRequest request);

    BaseResponse get(Long id);
    BaseResponse update(UpdateUserRequest request, Long id);

    BaseResponse delete(Long id);

    User findOneAndEnsureExistById(Long id);
}
