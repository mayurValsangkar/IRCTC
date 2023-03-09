package com.example.IRCTC.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainNumber;

    private String source;

    private String destination;

    @OneToMany(mappedBy = "trainEntity", cascade = CascadeType.ALL)
    private List<PassengerEntity> passengerEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "trainEntity", cascade = CascadeType.ALL)
    private List<FoodOrderEntity> foodOrderEntityList = new ArrayList<>();

}
