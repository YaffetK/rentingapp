package com.example.bokningsapp.repository;

import com.example.bokningsapp.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository <Equipment, Integer> {


}
