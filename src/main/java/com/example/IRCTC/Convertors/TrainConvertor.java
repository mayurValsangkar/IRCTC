package com.example.IRCTC.Convertors;

import com.example.IRCTC.DTOs.TrainEntryDto;
import com.example.IRCTC.Models.TrainEntity;

public class TrainConvertor {

    public static TrainEntity convertDtoToEntity(TrainEntryDto trainEntryDto){

        TrainEntity trainEntity = TrainEntity.builder().
                destination(trainEntryDto.getDestination()).
                source(trainEntryDto.getSource()).build();

        return trainEntity;
    }
}
