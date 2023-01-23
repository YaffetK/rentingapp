package com.example.bokningsapp.controller;


import com.example.bokningsapp.enums.BookingStatus;
import com.example.bokningsapp.enums.EquipmentStatus;
import com.example.bokningsapp.model.Equipment;
import com.example.bokningsapp.model.EquipmentBooking;
import com.example.bokningsapp.repository.EquipBookingRepo;
import com.example.bokningsapp.repository.EquipmentRepo;
import com.example.bokningsapp.service.EquipBookingService;
import com.example.bokningsapp.service.EquipBookingServiceImpl;
import com.example.bokningsapp.service.EquipmentService;
import com.example.bokningsapp.service.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;


@RestController
public class EquipBookingController {
    private final EquipBookingService equipBookingService;
    private final EquipmentService equipmentService;
    private EquipBookingRepo equipBookingRepo;
    private EquipmentRepo equipmentRepo;

    @Autowired
    public EquipBookingController(EquipBookingService equipBookingService, EquipmentService equipmentService, EquipBookingRepo equipBookingRepo, EquipmentRepo equipmentRepo) {
        this.equipBookingService = equipBookingService;
        this.equipmentService = equipmentService;
        this.equipmentRepo = equipmentRepo;
        this.equipBookingRepo = equipBookingRepo;
    }




    @PostMapping("/createBooking")
    public ResponseEntity<EquipmentBooking>createBooking(@RequestBody EquipmentBooking equipmentBooking){

        Equipment equipment = equipmentRepo.findById(equipmentBooking.getEquipment().getId()).orElseThrow();
        equipmentBooking.setEquipment(equipment);

        if(equipment.getEquipmentStatus() != EquipmentStatus.AVAILABLE) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        int totalBookedDays = equipmentBooking.getDurationInDays();
        if (totalBookedDays > 2) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        equipmentBooking.setStartDate(equipmentBooking.getStartDate());
        equipmentBooking.setEndDate(equipmentBooking.getEndDate());
        equipmentBooking.setPickUp(equipmentBooking.getPickUp());
        equipmentBooking.setDropOff(equipmentBooking.getDropOff());

        equipment.setEquipmentStatus(EquipmentStatus.UNAVAILABLE);
        equipmentBooking.setBookingStatus(BookingStatus.PENDING);

        equipBookingService.save(equipmentBooking);

        return new ResponseEntity<>(equipmentBooking, HttpStatus.CREATED);
    }

}
