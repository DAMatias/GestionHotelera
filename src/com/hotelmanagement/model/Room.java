package com.hotelmanagement.model;

import com.hotelmanagement.enums.RoomType;
import java.util.Date;

public class Room {
    private int roomNumber;
    private RoomType type;  // ← Uso del enum
    private double pricePerNight;
    private boolean isAvailable;

    // Constructor que recibe el enum
    public Room(int roomNumber, RoomType type, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;  // ← Asignación del enum
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    // ===== GETTERS =====
    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {  // ← Retorna el enum
        return type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // ===== SETTERS =====
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setType(RoomType type) {  // ← Recibe el enum
        this.type = type;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // ===== MÉTODOS QUE USAN EL ENUM =====
    
    // Método que usa el enum para calcular precio con descuento según tipo
    public double calculateTotalPrice(int days) {
        double basePrice = pricePerNight * days;
        
        // Aplicar descuento según el tipo de habitación
        if (type == RoomType.SIMPLE) {
            return basePrice;  // Sin descuento
        } else if (type == RoomType.DOUBLE) {
            return basePrice * 0.95;  // 5% descuento
        } else if (type == RoomType.SUITE) {
            return basePrice * 0.90;  // 10% descuento
        }
        
        return basePrice;
    }

    // Método que muestra información usando el enum
    public String getRoomDescription() {
        String description = "Habitación " + roomNumber + " - Tipo: ";
        
        switch (type) {
            case SIMPLE:
                description += "Simple (1 cama individual)";
                break;
            case DOUBLE:
                description += "Doble (1 cama matrimonial)";
                break;
            case SUITE:
                description += "Suite (cama king + sala de estar)";
                break;
        }
        
        description += " | Precio por noche: $" + pricePerNight;
        description += " | Disponible: " + (isAvailable ? "Sí" : "No");
        
        return description;
    }

    // Método que valida disponibilidad según fecha
    public boolean checkAvailability(Date date) {
        return isAvailable;
    }

    // Método que usa el enum para verificar si es una suite
    public boolean isSuite() {
        return type == RoomType.SUITE;
    }

    // Método que usa el enum para verificar si es doble
    public boolean isDouble() {
        return type == RoomType.DOUBLE;
    }

    // Método que usa el enum para verificar si es simple
    public boolean isSimple() {
        return type == RoomType.SIMPLE;
    }
}