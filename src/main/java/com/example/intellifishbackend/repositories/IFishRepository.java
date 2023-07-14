package com.example.intellifishbackend.repositories;

import com.example.intellifishbackend.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IFishRepository extends JpaRepository<Fish, Long> {

    List<Fish> findAllByUserId(Long id);
}
