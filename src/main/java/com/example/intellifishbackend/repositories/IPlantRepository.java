package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlantRepository extends JpaRepository<Plant, Long> {

}
