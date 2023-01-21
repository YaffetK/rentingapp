package com.example.bokningsapp.service;

import com.example.bokningsapp.model.EquipmentBooking;
import com.example.bokningsapp.repository.EquipBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class EquipBookingServiceImpl implements EquipBookingService {

    @Autowired
    EquipBookingRepo equipBookingRepo;


}
