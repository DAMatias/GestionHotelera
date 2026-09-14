package com.hotelmanagement.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Guest extends Person {
    private String email;
    private String phone;
    private List<Reservation> reservations;

    public Guest(String name, String lastName, String dni, Date birthDate, String email, String phone) {
        super(name, lastName, dni, birthDate);
        this.email = email;
        this.phone = phone;
        this.reservations = new ArrayList<>();
    }

    // ===== GETTERS Y SETTERS =====
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    @Override
    public void printRoleDetails() {
        System.out.println("Huésped: " + getName() + " " + getLastName() + " | Email: " + email);
    }
}