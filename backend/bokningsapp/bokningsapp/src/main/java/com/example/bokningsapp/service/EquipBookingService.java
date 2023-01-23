package com.example.bokningsapp.service;
import com.example.bokningsapp.enums.BookingStatus;
import com.example.bokningsapp.model.EquipmentBooking;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EquipBookingService {
    public EquipmentBooking save(EquipmentBooking equipmentBooking);

    public List<EquipmentBooking> findAllByStatus(BookingStatus status);

    public List<EquipmentBooking> findAll();
}
