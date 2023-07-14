package com.example.intellifishbackend.controllers;

import com.example.intellifishbackend.controllers.dtos.requests.CreateFishRequest;
import com.example.intellifishbackend.controllers.dtos.requests.CreateUserRequest;
import com.example.intellifishbackend.controllers.dtos.requests.UpdateFishRequest;
import com.example.intellifishbackend.controllers.dtos.requests.UpdateUserRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get (@PathVariable Long id){

        BaseResponse baseResponse = service.get(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateUserRequest request){
        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateUserRequest request){
        BaseResponse baseResponse = service.update(request, id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id){
        BaseResponse baseResponse = service.delete(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }


}
