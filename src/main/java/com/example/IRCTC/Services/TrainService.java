package com.example.IRCTC.Services;

import com.example.IRCTC.Convertors.TrainConvertor;
import com.example.IRCTC.DTOs.TrainEntryDto;
import com.example.IRCTC.Models.TrainEntity;
import com.example.IRCTC.Repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public void addTrain(TrainEntryDto trainEntryDto){

        TrainEntity trainEntity = TrainConvertor.convertDtoToEntity(trainEntryDto);

        trainRepository.save(trainEntity);
    }
}
