package com.example.bokningsapp.model;

import com.example.bokningsapp.types.EquipmentType;
import com.example.bokningsapp.types.Status;
import jakarta.persistence.*;

@Table
@Entity
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cameraId;

    private String cameraName;

    private String cameraLocation;

    private String cameraImg;

    private int maxDaysToRent;

   private String cameraDescription;

    private String cameraBrand;



   private EquipmentType CameraType;

   private Status CameraStatus;


}
