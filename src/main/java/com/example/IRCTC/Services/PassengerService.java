package com.example.IRCTC.Services;

import com.example.IRCTC.Convertors.PassengerConvertor;
import com.example.IRCTC.DTOs.PassengerEntryDto;
import com.example.IRCTC.Models.PassengerEntity;
import com.example.IRCTC.Models.TrainEntity;
import com.example.IRCTC.Repositories.PassengerRepository;
import com.example.IRCTC.Repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    TrainRepository trainRepository;

    public void addPassenger(PassengerEntryDto passengerEntryDto){

        PassengerEntity passengerEntity = PassengerConvertor.convertDtoToEntity(passengerEntryDto);

        int trainId = passengerEntity.getTrainId();

        TrainEntity trainEntity = trainRepository.findById(trainId).get();

        trainEntity.getPassengerEntityList().add(passengerEntity);

        // Saving parent
        trainRepository.save(trainEntity);
    }

    public int getPassengers(String source, String destination, Date date){

        int numberOfPassengers = 0;

        List<PassengerEntity> passengerEntityList = passengerRepository.findAll();

        for(PassengerEntity passengerEntity : passengerEntityList){

            if(passengerEntity.getDate().equals(date)){
                TrainEntity trainEntity = passengerEntity.getTrainEntity();

                if(trainEntity.getSource().equals(source) && trainEntity.getDestination().equals(destination)){
                    numberOfPassengers += 1;
                }
            }
        }

        return numberOfPassengers;
    }

    public int getFemalePassengersOfParticularAge(int x, int y, String destination){

        int numberOfFemalePassengers = 0;

        List<PassengerEntity> passengerEntityList = passengerRepository.findAll();

        for(PassengerEntity passengerEntity : passengerEntityList){

            TrainEntity trainEntity = passengerEntity.getTrainEntity();
            if(trainEntity.getDestination().equals(destination)){

                if(passengerEntity.getAge() > x && passengerEntity.getAge() < y){
                    numberOfFemalePassengers += 1;
                }
            }
        }

        return numberOfFemalePassengers;
    }
}
