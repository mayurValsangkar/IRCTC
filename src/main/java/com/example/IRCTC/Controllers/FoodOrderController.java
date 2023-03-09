package com.example.IRCTC.Controllers;

import com.example.IRCTC.Services.FoodOrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/food-order")
public class FoodOrderController {

    @Autowired
    FoodOrderService foodOrderService;

    @GetMapping("/get-total-order-bill")
    public ResponseEntity getPrice(@RequestParam("trainId") int trainId, @RequestParam("date") Date date){

        int totalOrderBill = 0;

        try {
            totalOrderBill = foodOrderService.getTotalOrderBillOnDay(trainId, date);
        }catch (Exception e){
            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(totalOrderBill, HttpStatus.ACCEPTED);
    }
}
