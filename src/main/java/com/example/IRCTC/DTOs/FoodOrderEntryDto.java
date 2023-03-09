package com.example.IRCTC.DTOs;

import lombok.Data;

@Data
public class FoodOrderEntryDto {

    private int ticketId;

    private int trainId;

    private int price;
}
