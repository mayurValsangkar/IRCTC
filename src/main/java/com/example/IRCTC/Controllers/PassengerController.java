package com.example.IRCTC.Controllers;

import com.example.IRCTC.DTOs.PassengerEntryDto;
import com.example.IRCTC.Models.PassengerEntity;
import com.example.IRCTC.Services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PassengerEntryDto passengerEntryDto){

        try {
            passengerService.addPassenger(passengerEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>("Passenger could not be added", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Passenger added successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-particular-passengers")
    public ResponseEntity get(@RequestParam("source") String source, @RequestParam("dest") String dest, @RequestParam("date") Date date){

        int numbers = 0;
        try {
            numbers = passengerService.getPassengers(source, dest, date);
        }catch (Exception e){
            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(numbers, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-female-passengers")
    public ResponseEntity getFemalePassengers(@RequestParam("age1") int age1, @RequestParam("age2") int age2, @RequestParam("dest") String dest){

        int numbers = 0;
        try {
            numbers = passengerService.getFemalePassengersOfParticularAge(age1, age2, dest);
        }catch (Exception e){
            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(numbers, HttpStatus.ACCEPTED);
    }



}
