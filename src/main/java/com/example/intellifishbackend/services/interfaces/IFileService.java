package com.example.intellifishbackend.services.interfaces;

import com.example.intellifishbackend.controllers.dtos.responses.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    BaseResponse upload(MultipartFile multipartFile);

    void delete(String imageUrl);


}
