package com.example.bokningsapp.service;

import com.example.bokningsapp.enums.EquipmentStatus;
import com.example.bokningsapp.enums.EquipmentType;
import com.example.bokningsapp.model.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmentService {
    public Equipment saveEquipment(Equipment equipment);
    public List<Equipment> createEquipmentByType(EquipmentType type);
    public void updateEquipmentStatus(int equipmentId, boolean isBooked);
}
