package com.example.bokningsapp.service;

import com.example.bokningsapp.enums.BookingStatus;
import com.example.bokningsapp.model.EquipmentBooking;
import com.example.bokningsapp.repository.EquipBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EquipBookingServiceImpl implements EquipBookingService {

  private final EquipBookingRepo equipBookingRepo;
  @Autowired
    public EquipBookingServiceImpl(EquipBookingRepo equipBookingRepo) {
        this.equipBookingRepo = equipBookingRepo;
    }

    @Override
    public EquipmentBooking save(EquipmentBooking equipmentBooking) {
        return equipBookingRepo.save(equipmentBooking);
    }

    @Override
    public List<EquipmentBooking> findAllByStatus(BookingStatus status){
        return equipBookingRepo.findAllByBookingStatus(status);
    }

    @Override
    public List<EquipmentBooking> findAll() {
        return equipBookingRepo.findAll();
    }
}
