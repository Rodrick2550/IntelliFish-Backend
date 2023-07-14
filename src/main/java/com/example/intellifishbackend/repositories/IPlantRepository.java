package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.Fish;
import com.example.intellifishbackend.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findAllByUserId(Long id);
}
