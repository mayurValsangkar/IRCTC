package com.example.IRCTC.Repositories;

import com.example.IRCTC.Models.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<TrainEntity, Integer> {
}
