package com.example.bokningsapp.repository;

import com.example.bokningsapp.enums.BookingStatus;
import com.example.bokningsapp.model.EquipmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipBookingRepo extends JpaRepository <EquipmentBooking, Long>{

    List<EquipmentBooking> findAllByBookingStatus(BookingStatus status);

    List<EquipmentBooking>findAll();

}
