package com.example.bokningsapp.repository;

import com.example.bokningsapp.model.EquipmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipBookingRepo extends JpaRepository <EquipmentBooking, Integer>{
}
