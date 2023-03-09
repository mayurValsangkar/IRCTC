package com.example.IRCTC.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int ticketId;

    private int trainId;

    private int price;

    @ManyToOne
    @JoinColumn
    private TrainEntity trainEntity;

    @ManyToOne
    @JoinColumn
    private PassengerEntity passengerEntity;

}
