package com.example.IRCTC.Controllers;

import com.example.IRCTC.DTOs.TrainEntryDto;
import com.example.IRCTC.Services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    TrainService trainService;

    public ResponseEntity add(@RequestBody TrainEntryDto trainEntryDto){

        try {
            trainService.addTrain(trainEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>("train could not be added", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("train added successfully", HttpStatus.ACCEPTED);
    }
}
