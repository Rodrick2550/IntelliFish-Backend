package com.example.intellifishbackend.services;

import com.example.intellifishbackend.controllers.dtos.requests.CreateUserRequest;
import com.example.intellifishbackend.controllers.dtos.requests.UpdateUserRequest;
import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import com.example.intellifishbackend.controllers.dtos.responses.UserResponse;
import com.example.intellifishbackend.controllers.exceptions.AccessDeniedException;
import com.example.intellifishbackend.controllers.exceptions.ObjectNotFoundException;
import com.example.intellifishbackend.controllers.exceptions.UniqueConstraintViolationException;
import com.example.intellifishbackend.entities.User;
import com.example.intellifishbackend.repositories.IUserRepository;
import com.example.intellifishbackend.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    private static UserDetailsImpl getUserAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetailsImpl) authentication.getPrincipal();
    }

    @Override
    public BaseResponse create(CreateUserRequest request){

        if (repository.existsByCode(request.getCode()))
            throw new UniqueConstraintViolationException("Code already registered ");

        User user = repository.save(from(request));

        return BaseResponse.builder()
                .data(from(user))
                .message("User created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();

    }

    @Override
    public BaseResponse get(Long id) {

        UserDetailsImpl userDetails = getUserAuthenticated();

        if (!userDetails.getUser().getId().equals(id)){
            throw new AccessDeniedException();
        }

        User user = findOneAndEnsureExistById(id);

        return BaseResponse.builder()
                .data(from(user))
                .message("User Found")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse update(UpdateUserRequest request, Long id) {

        User userAuthenticated = getUserAuthenticated().getUser();

        if (!userAuthenticated.getId().equals(id)){
            throw new AccessDeniedException();
        }

        if(repository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already Use");
        }


        return BaseResponse.builder()
                .data(from(userAuthenticated))
                .message("Data user update correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse delete(Long id) {

        User user = getUserAuthenticated().getUser();

        if(!repository.existsById(id)){
            throw new ObjectNotFoundException("User not found");
        }

        if (!user.getId().equals(id)){
            throw new AccessDeniedException();
        }

        repository.deleteById(id);
        return BaseResponse.builder()
                .data(Collections.EMPTY_LIST)
                .message("User deleted successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT)
                .build();
    }

    @Override
    public User findOneAndEnsureExistById(Long id) {
        return  repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("The user does not exist"));
    }



    private User from(CreateUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setCode(request.getCode());
        user.setPassword(encodePassword(request.getPassword()));

        return user;
    }
    private User update(User user, UpdateUserRequest request){
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPassword(encodePassword(request.getPassword()));
        repository.save(user);

        return user;
    }
    private UserResponse from (User user){

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());
        userResponse.setLastname(user.getLastname());
        userResponse.setCode(user.getCode());

        return userResponse;

    }

    private static String encodePassword(String request){
        return new BCryptPasswordEncoder().encode(request);
    }

}
