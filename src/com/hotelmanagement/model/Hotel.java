package com.hotelmanagement.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Hotel {
    private String name;
    private String address;
    private double obtainedStars;
    private List<Room> rooms;
    private Set<Employee> employees;
    private List<Rating> ratings;

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
        this.rooms = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.employees = new HashSet<>();
    }

    // ===== GETTERS Y SETTERS =====
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getObtainedStars() { return obtainedStars; }
    public void setObtainedStars(double obtainedStars) { this.obtainedStars = obtainedStars; }
    public List<Room> getRooms() { return rooms; }
    public void setRooms(List<Room> rooms) { this.rooms = rooms; }
    public Set<Employee> getEmployees() { return employees; }
    public void setEmployees(Set<Employee> employees) { this.employees = employees; }
    public List<Rating> getRatings() { return ratings; }
    public void setRatings(List<Rating> ratings) { this.ratings = ratings; }

    // ===== MÉTODOS ADICIONALES =====
    public void addRoom(Room room) { this.rooms.add(room); }
    public void addEmployee(Employee employee) { this.employees.add(employee); }
    public void addRating(Rating rating) { this.ratings.add(rating); }

    public double calculateAverageStars() {
        if (ratings.isEmpty()) return 0.0;
        double sum = 0;
        for (Rating r : ratings) {
            sum += r.getValue();
        }
        return sum / ratings.size();
    }
}