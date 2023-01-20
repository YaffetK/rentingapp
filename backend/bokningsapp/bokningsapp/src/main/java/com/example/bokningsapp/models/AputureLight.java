package com.example.bokningsapp.models;

import com.example.bokningsapp.enums.EquipmentType;
import com.example.bokningsapp.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name="Light")
public class AputureLight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lightId;

    @Column
    private String lightName;

    @Column
    private String lightLocation;

    @Column
    private String lightImg;

    @Column
    private int maxDaysToRent;

    @Column
    private String lightDescription;

    @Column
    private String lightBrand;

    @Column
    private EquipmentType LightType;

    @Column
    private Status LightStatus;

    public AputureLight() {
    }

    public int getLightId() {
        return lightId;
    }

    public void setLightId(int lightId) {
        this.lightId = lightId;
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }

    public String getLightLocation() {
        return lightLocation;
    }

    public void setLightLocation(String lightLocation) {
        this.lightLocation = lightLocation;
    }

    public String getLightImg() {
        return lightImg;
    }

    public void setLightImg(String lightImg) {
        this.lightImg = lightImg;
    }

    public int getMaxDaysToRent() {
        return maxDaysToRent;
    }

    public void setMaxDaysToRent(int maxDaysToRent) {
        this.maxDaysToRent = maxDaysToRent;
    }

    public String getLightDescription() {
        return lightDescription;
    }

    public void setLightDescription(String lightDescription) {
        this.lightDescription = lightDescription;
    }

    public String getLightBrand() {
        return lightBrand;
    }

    public void setLightBrand(String lightBrand) {
        this.lightBrand = lightBrand;
    }

    public EquipmentType getLightType() {
        return LightType;
    }

    public void setLightType(EquipmentType lightType) {
        LightType = lightType;
    }

    public Status getLightStatus() {
        return LightStatus;
    }

    public void setLightStatus(Status lightStatus) {
        LightStatus = lightStatus;
    }

    @Override
    public String toString() {
        return "AputureLight{" +
                "lightId=" + lightId +
                ", lightName='" + lightName + '\'' +
                ", lightLocation='" + lightLocation + '\'' +
                ", lightImg='" + lightImg + '\'' +
                ", maxDaysToRent=" + maxDaysToRent +
                ", lightDescription='" + lightDescription + '\'' +
                ", lightBrand='" + lightBrand + '\'' +
                ", LightType=" + LightType +
                ", LightStatus=" + LightStatus +
                '}';
    }
}
