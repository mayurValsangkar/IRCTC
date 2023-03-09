package com.example.IRCTC.Services;

import com.example.IRCTC.Models.FoodOrderEntity;
import com.example.IRCTC.Models.PassengerEntity;
import com.example.IRCTC.Models.TrainEntity;
import com.example.IRCTC.Repositories.FoodOrderRepository;
import com.example.IRCTC.Repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FoodOrderService {

    @Autowired
    FoodOrderRepository foodOrderRepository;

    @Autowired
    TrainRepository trainRepository;

    public int getTotalOrderBillOnDay(int trainId, Date date){

        int totalOrderBill = 0;

        TrainEntity trainEntity = trainRepository.findById(trainId).get();

        List<FoodOrderEntity> foodOrderEntityList = trainEntity.getFoodOrderEntityList();

        for(FoodOrderEntity foodOrderEntity : foodOrderEntityList){

            if(foodOrderEntity.getPassengerEntity().getDate().equals(date)){

                totalOrderBill += foodOrderEntity.getPrice();
            }
        }

        return totalOrderBill;
    }
}
