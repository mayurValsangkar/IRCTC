package com.example.IRCTC.Models;

import com.example.IRCTC.Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "passenger")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    private int trainId;

    private Date date;

    private int age;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn
    private TrainEntity trainEntity;

    @OneToMany(mappedBy = "passengerEntity", cascade = CascadeType.ALL)
    private List<FoodOrderEntity> foodOrderEntityList = new ArrayList<>();

}
