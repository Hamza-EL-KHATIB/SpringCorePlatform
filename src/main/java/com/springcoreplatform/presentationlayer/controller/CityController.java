package com.springcoreplatform.presentationlayer.controller;

import com.springcoreplatform.presentationlayer.model.response.FileUploadResponseMessage;
import com.springcoreplatform.service.CityService;
import com.springcoreplatform.service.FileService;
import com.springcoreplatform.shared.dto.CityDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;
    private final FileService fileService;

    @Autowired
    public CityController(CityService cityService, FileService fileService) {
        this.cityService = cityService;
        this.fileService = fileService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiImplicitParams({@ApiImplicitParam(name = "authorization", value = "Bearer JWT Token", paramType = "header")})
    public List<CityDto> getUsers() {
        return cityService.getCities();
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "authorization", value = "Bearer JWT Token", paramType = "header")})
    @PostMapping(path = {"/newCity"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CityDto addCity(@RequestBody CityDto cityDto) {
        return cityService.addCity(cityDto);
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "authorization", value = "Bearer JWT Token", paramType = "header")})
    @PostMapping(path = {"/newRandomCity"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CityDto addRandomCity() {
        return cityService.addRandomCity();
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "authorization", value = "Bearer JWT Token", paramType = "header")})
    @PostMapping("/upload")
    public ResponseEntity<FileUploadResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;
        try {
            fileService.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();

            FileUploadResponseMessage response = new FileUploadResponseMessage();
            response.setMessage(message);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();

            FileUploadResponseMessage response = new FileUploadResponseMessage();
            response.setMessage(message);

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }
    }
}