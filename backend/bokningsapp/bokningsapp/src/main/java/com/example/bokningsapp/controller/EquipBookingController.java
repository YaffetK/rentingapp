package com.example.bokningsapp.controller;


import com.example.bokningsapp.model.Equipment;
import com.example.bokningsapp.model.EquipmentBooking;
import com.example.bokningsapp.repository.EquipBookingRepo;
import com.example.bokningsapp.repository.EquipmentRepo;
import com.example.bokningsapp.service.EquipBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class EquipBookingController {

    @Autowired
    private EquipBookingService equipBookingService;
    @Autowired
    private EquipBookingRepo equipBookingRepo;
    @Autowired
    private EquipmentRepo equipmentRepo;

    @PostMapping("createBooking")
    public String addBooking(@RequestBody EquipmentBooking equipmentBooking){


        Equipment equipment = equipmentRepo.findById(equipmentBooking.getEquipment().getEquipmentId()).orElseThrow(null);
        equipmentBooking.setEquipment(equipment);


      //  equipmentBooking.setStartDate(startDate); //Till datumet som anges
        Date startDate = equipmentBooking.getStartDate(); //validera att datum som anges är valid tex inte tillbaks i tiden
        // boolean before(Date date)	tests if current date is before the given date.
        int totalBookedDays = equipmentBooking.getDurationInDays();
        if (totalBookedDays > 2) {
            return "Renting has a max duration of 2 days";
        }

        equipBookingRepo.save(equipmentBooking);

        return "Booking has been created";
    }

   // boolean before(Date date)	tests if current date is before the given date.


}
