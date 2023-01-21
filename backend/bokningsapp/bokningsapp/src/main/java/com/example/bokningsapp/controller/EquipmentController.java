package com.example.bokningsapp.controller;

import com.example.bokningsapp.enums.EquipmentType;
import com.example.bokningsapp.model.Equipment;
import com.example.bokningsapp.repository.EquipmentRepo;
import com.example.bokningsapp.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipmentController {
    @Autowired
    private EquipmentRepo equipmentRepo;
    @Autowired
    private EquipmentService equipmentService;


    @GetMapping(value = "/allEquipment")
    public List<Equipment> getAllEquipment() {
        return equipmentRepo.findAll();
    }

    @PostMapping(value = "/createEquipment")
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {

        Equipment newEquipment = equipmentService.saveEquipment(equipment);
        return new ResponseEntity<>(newEquipment, HttpStatus.CREATED);
    }

    @PostMapping("/byType")
    public ResponseEntity<List<Equipment>> createEquipmentsByType(@RequestParam("type") EquipmentType type) {
        List<Equipment> equipment = equipmentService.createEquipmentByType(type);
        return new ResponseEntity<>(equipment, HttpStatus.CREATED);
    }

}

