package com.hotelmanagement.model;

import com.hotelmanagement.enums.ReservationStatus;
import java.util.Date;

public class Reservation {
    private Date startDate;
    private Date endDate;
    private ReservationStatus status;
    private Room room;

    public Reservation(Date startDate, Date endDate, Room room) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.status = ReservationStatus.PENDING;
    }

    // ===== GETTERS Y SETTERS =====
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public ReservationStatus getStatus() { return status; }
    public void setStatus(ReservationStatus status) { this.status = status; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    // ===== MÉTODOS DE NEGOCIO (Mensajes en español) =====
    public void confirm() {
        this.status = ReservationStatus.CONFIRMED;
        System.out.println("Reserva confirmada exitosamente.");
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELED;
        System.out.println("Reserva cancelada.");
    }

    public void finish() {
        this.status = ReservationStatus.FINISHED;
        System.out.println("Reserva finalizada. El huésped ha dejado la habitación.");
    }
}