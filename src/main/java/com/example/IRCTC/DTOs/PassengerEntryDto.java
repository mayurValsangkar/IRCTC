package com.example.IRCTC.DTOs;

import com.example.IRCTC.Enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class PassengerEntryDto {

    private int trainId;

    private Date date;

    private int age;

    private Gender gender;
}
