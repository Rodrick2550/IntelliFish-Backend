package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.controllers.dtos.requests.AuthenticationRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;

public interface IAuthService {

    BaseResponse authenticate(AuthenticationRequest request);
}
