package com.hotelmanagement.model;

import com.hotelmanagement.enums.EmployeeRole;
import java.util.Date;

public class Employee extends Person {
    private EmployeeRole role;
    private double salary;

    public Employee(String name, String lastName, String dni, Date birthDate, EmployeeRole role, double salary) {
        super(name, lastName, dni, birthDate);
        this.role = role;
        this.salary = salary;
    }

    // ===== GETTERS Y SETTERS =====
    public EmployeeRole getRole() { return role; }
    public void setRole(EmployeeRole role) { this.role = role; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    // ===== MÉTODOS DE NEGOCIO (Mensajes en español) =====
    public void manageReservation(Reservation reservation) {
        if (this.role == EmployeeRole.RECEPTION) {
            System.out.println("Reserva gestionada exitosamente por el recepcionista " + getName());
        } else {
            System.out.println("Error: Solo el personal de RECEPCIÓN puede gestionar reservas.");
        }
    }

    public void registerCleaning(Room room) {
        if (this.role == EmployeeRole.CLEANING) {
            System.out.println("La habitación " + room.getRoomNumber() + " fue limpiada por " + getName());
        } else {
            System.out.println("Error: Solo el personal de LIMPIEZA puede registrar limpiezas.");
        }
    }

    @Override
    public void printRoleDetails() {
        System.out.println("Empleado: " + getName() + " | Cargo: " + role);
    }
}