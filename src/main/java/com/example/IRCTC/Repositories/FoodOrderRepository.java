package com.example.IRCTC.Repositories;

import com.example.IRCTC.Models.FoodOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrderEntity, Integer> {
}
