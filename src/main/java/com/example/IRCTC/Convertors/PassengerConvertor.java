package com.example.IRCTC.Convertors;

import com.example.IRCTC.DTOs.PassengerEntryDto;
import com.example.IRCTC.Models.PassengerEntity;

public class PassengerConvertor {

    public static PassengerEntity convertDtoToEntity(PassengerEntryDto passengerEntryDto){

        PassengerEntity passengerEntity = PassengerEntity.builder().
                age(passengerEntryDto.getAge()).
                date(passengerEntryDto.getDate()).
                gender(passengerEntryDto.getGender()).
                trainId(passengerEntryDto.getTrainId()).
                build();

        return passengerEntity;
    }


}
