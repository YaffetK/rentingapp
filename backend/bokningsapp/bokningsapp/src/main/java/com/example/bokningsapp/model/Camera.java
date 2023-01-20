package com.example.bokningsapp.model;

import com.example.bokningsapp.enums.EquipmentType;
import com.example.bokningsapp.enums.EquipmentStatus;
import jakarta.persistence.*;

@Entity
@Table(name="camera")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cameraId;

    @Column
    private String cameraName;

    @Column
    private String cameraLocation;

    @Column
    private String cameraImg;

    @Column
    private int maxDaysToRent;

    @Column
    private String cameraDescription;

    @Column
    private String cameraBrand;

    @Column
    private EquipmentType CameraType;

    @Column
    private EquipmentStatus CameraStatus;

    public Camera() {
    }

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getCameraLocation() {
        return cameraLocation;
    }

    public void setCameraLocation(String cameraLocation) {
        this.cameraLocation = cameraLocation;
    }

    public String getCameraImg() {
        return cameraImg;
    }

    public void setCameraImg(String cameraImg) {
        this.cameraImg = cameraImg;
    }

    public int getMaxDaysToRent() {
        return maxDaysToRent;
    }

    public void setMaxDaysToRent(int maxDaysToRent) {
        this.maxDaysToRent = maxDaysToRent;
    }

    public String getCameraDescription() {
        return cameraDescription;
    }

    public void setCameraDescription(String cameraDescription) {
        this.cameraDescription = cameraDescription;
    }

    public String getCameraBrand() {
        return cameraBrand;
    }

    public void setCameraBrand(String cameraBrand) {
        this.cameraBrand = cameraBrand;
    }

    public EquipmentType getCameraType() {
        return CameraType;
    }

    public void setCameraType(EquipmentType cameraType) {
        CameraType = cameraType;
    }

    public EquipmentStatus getCameraStatus() {
        return CameraStatus;
    }

    public void setCameraStatus(EquipmentStatus cameraStatus) {
        CameraStatus = cameraStatus;
    }


    @Override
    public String toString() {
        return "Camera{" +
                "cameraId=" + cameraId +
                ", cameraName='" + cameraName + '\'' +
                ", cameraLocation='" + cameraLocation + '\'' +
                ", cameraImg='" + cameraImg + '\'' +
                ", maxDaysToRent=" + maxDaysToRent +
                ", cameraDescription='" + cameraDescription + '\'' +
                ", cameraBrand='" + cameraBrand + '\'' +
                ", CameraType=" + CameraType +
                ", CameraStatus=" + CameraStatus +
                '}';
    }
}