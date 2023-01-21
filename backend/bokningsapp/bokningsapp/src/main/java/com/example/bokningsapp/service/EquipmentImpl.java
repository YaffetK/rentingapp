package com.example.bokningsapp.service;

import com.example.bokningsapp.enums.EquipmentStatus;
import com.example.bokningsapp.enums.EquipmentType;
import com.example.bokningsapp.model.Equipment;
import com.example.bokningsapp.repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class EquipmentImpl implements EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Override
    public Equipment saveEquipment (Equipment equipment){
        return equipmentRepo.save(equipment);
    }

    @Override
    public List<Equipment> createEquipmentByType(EquipmentType type) {
        List<Equipment> equipment = new ArrayList<>();
        //create products based on the type
        Equipment light = new Equipment("LS 6000d Pro", "Changers Kista", "/Users/luliyamasfun/Desktop/iPhone 12-13/apututre.png",
                2, "The LS 600x Pro boasts an expanded bi-color range of 2700K~6500K while still being able maintain " +
                        "an impressive output. Equipped with its native Hyper-Reflector, the 600x Pro can output 5,610 lux at 3 meters " +
                        "(10 feet). With the F10 Fresnel modifier, the combination can reach an illuminance of 18,510 lux at 3 meters in 15° spot.",
                "Aputure", EquipmentType.LIGHT);
        Equipment sound = new Equipment("The Rode Procaster", "Changers Kista", "/Users/luliyamasfun/Desktop/iPhone 12-13/rode1.png",
                2, "The Rode Procaster is a professional-grade dynamic microphone that is designed for use in broadcast, podcast, and " +
                "voiceover applications. It features a tight polar pattern and a tailored frequency response that provide excellent clarity, " +
                "minimal background noise, and superior rejection of off-axis sound.", "Rode", EquipmentType.SOUND);
        Equipment camera = new Equipment("Canon C70", "Changers Kista", "/Users/luliyamasfun/Desktop/iPhone 12-13/canon1.png",
                2, "The EOS C70 introduces RF mount to the Cinema EOS system and features Canon's ground-breaking 4K Super 35mm DGO sensor." +
                " With 12-bit RAW recording, 4K 120P slow motion, high dynamic range and eye AF in a compact camera, it takes the RF system to a whole new era.",
                "Canon", EquipmentType.CAMERA);
        equipment.add(camera);
        equipment.add(sound);
        equipment.add(light);
        equipmentRepo.saveAll(equipment);
        return equipment;
    }

    @Override
    public void updateEquipmentStatus(int equipmentId, boolean isBooked) {
        Equipment equipment = equipmentRepo.findById(equipmentId).orElse(null);
        if (equipment != null) {
            if (isBooked) {
                equipment.setEquipmentStatus(EquipmentStatus.UNAVAILABLE);
            } else {
                equipment.setEquipmentStatus(EquipmentStatus.AVAILABLE);
            }
            equipmentRepo.save(equipment);
        }
    }
}
