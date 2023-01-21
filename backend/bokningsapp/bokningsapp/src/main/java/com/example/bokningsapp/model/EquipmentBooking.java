package com.example.bokningsapp.model;

import com.example.bokningsapp.enums.BookingStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.sql.Time;


@Entity
@Table(name = "equipment_booking")
public class EquipmentBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column
    private String reservationNumber;

    //@JoinColumn(name = "user_id", referencedColumnName = "id")
   // private User user;

    @Column
    private String EquipBookedImg;

    @Column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    private Equipment equipment;
    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private BookingStatus bookingStatus;

    @Column
    private Time pickUp;

    @Column
    private Time dropOff;

    @Column
    private int DurationInDays;

    public EquipmentBooking() {
    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Time getPickUp() {
        return pickUp;
    }

    public void setPickUp(Time pickUp) {
        this.pickUp = pickUp;
    }

    public Time getDropOff() {
        return dropOff;
    }

    public void setDropOff(Time dropOff) {
        this.dropOff = dropOff;
    }

    public String getEquipBookedImg() {
        return EquipBookedImg;
    }

    public void setEquipBookedImg(String equipBookedImg) {
        EquipBookedImg = equipBookedImg;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }



   // public User getUser() {
   //     return user;
  //  }

   // public void setUser(User user) {
   //     this.user = user;
  //  }


    public int getDurationInDays() {
        return DurationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        DurationInDays = durationInDays;
    }

    @Override
    public String toString() {
        return "EquipmentBooking{" +
                "bookingId=" + bookingId +
                ", reservationNumber='" + reservationNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", bookingStatus=" + bookingStatus +
                ", pickUp=" + pickUp +
                ", dropOff=" + dropOff +
                '}';
    }
}
