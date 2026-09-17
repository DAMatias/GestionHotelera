package com.hotelmanagement.main;

import com.hotelmanagement.enums.*;
import com.hotelmanagement.model.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  SISTEMA DE GESTIÓN HOTELERA - INICIO  ");
        System.out.println("========================================\n");

        // 1. Instanciar el Hotel
        Hotel myHotel = new Hotel("Diaz Somma Resort", "Av. Siempre Viva 123");
        System.out.println("Hotel creado: " + myHotel.getName());
        System.out.println("Dirección: " + myHotel.getAddress() + "\n");

        // 2. COMPOSICIÓN: Creamos habitaciones usando el enum RoomType
        System.out.println("--- Agregando habitaciones al hotel (Composición) ---");
        
        // Crear habitaciones con diferentes tipos (enum)
        Room room101 = new Room(101, RoomType.SIMPLE, 50.0);
        Room room202 = new Room(202, RoomType.DOUBLE, 80.0);
        Room room303 = new Room(303, RoomType.SUITE, 150.0);
        
        myHotel.addRoom(room101);
        myHotel.addRoom(room202);
        myHotel.addRoom(room303);
        
        // Mostrar descripciones usando el enum
        System.out.println(room101.getRoomDescription());
        System.out.println(room202.getRoomDescription());
        System.out.println(room303.getRoomDescription());
        System.out.println();

        // 3. DEMOSTRACIÓN DEL USO DEL ENUM
        System.out.println("--- Verificación de tipos de habitaciones (uso de enum) ---");
        
        if (room101.isSimple()) {
            System.out.println("✓ La habitación 101 es SIMPLE");
        }
        
        if (room202.isDouble()) {
            System.out.println("✓ La habitación 202 es DOBLE");
        }
        
        if (room303.isSuite()) {
            System.out.println("✓ La habitación 303 es SUITE");
        }
        System.out.println();

        // 4. CÁLCULO DE PRECIOS USANDO EL ENUM
        System.out.println("--- Cálculo de precios según tipo de habitación (5 noches) ---");
        
        int days = 5;
        System.out.println("Habitación 101 (SIMPLE): $" + room101.calculateTotalPrice(days) + " (sin descuento)");
        System.out.println("Habitación 202 (DOBLE): $" + room202.calculateTotalPrice(days) + " (5% descuento)");
        System.out.println("Habitación 303 (SUITE): $" + room303.calculateTotalPrice(days) + " (10% descuento)");
        System.out.println();
        
        // MUESTA DE HOTELES DE LA CADENA
        System.out.println("--- Hoteles pertenecientes a la cadena ---");
        int numberHotels = Hotel.getAmountHotels();
        System.out.println("La cadena posee un total de " + numberHotels + " hoteles.");
        System.out.println();

        // 5. AGREGACIÓN: Creamos empleados y los asociamos al hotel
        System.out.println("--- Contratando empleados (Agregación) ---");
        Employee receptionist = new Employee("Juan", "Pérez", "12345678", new Date(80, 5, 15), EmployeeRole.RECEPTION, 3000.0);
        Employee cleaner = new Employee("María", "González", "87654321", new Date(85, 10, 20), EmployeeRole.CLEANING, 1500.0);
        
        myHotel.addEmployee(receptionist);
        myHotel.addEmployee(cleaner);
        System.out.println("Recepcionista contratado: " + receptionist.getName());
        System.out.println("Personal de limpieza contratado: " + cleaner.getName() + "\n");

        // 6. POLIMORFISMO: Lista de Personas
        System.out.println("--- Prueba de Polimorfismo: Cálculo de edades ---");
        List<Person> people = new ArrayList<>();
        people.add(new Guest("Ana", "López", "11111111", new Date(90, 5, 15), "ana@mail.com", "123456"));
        people.add(receptionist);
        people.add(cleaner);

        for (Person p : people) {
            System.out.println(p.getName() + " tiene " + p.calculateAge(p.getBirthDate()) + " años.");
            p.printRoleDetails();
        }
        System.out.println();

        // 7. VALIDACIÓN DE RESTRICCIONES
        System.out.println("--- Prueba de Reglas de Negocio ---");
        System.out.println("Intentando que el recepcionista gestione una reserva:");
        receptionist.manageReservation(null);
        
        System.out.println("Intentando que el personal de limpieza gestione una reserva:");
        cleaner.manageReservation(null);
        
        System.out.println("Intentando que el personal de limpieza registre una limpieza:");
        cleaner.registerCleaning(room303);
        
        System.out.println("Intentando que el recepcionista registre una limpieza:");
        receptionist.registerCleaning(room303);
        System.out.println();

        // 8. VALIDACIÓN DE RANGO (Puntuación)
        System.out.println("--- Prueba de Validación de Puntuación ---");
        try {
            System.out.println("Intentando crear una puntuación con valor 6 (inválido):");
            new Rating(6, "Demasiado alto", new Date());
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        try {
            System.out.println("Creando puntuación válida con valor 4:");
            Rating validRating = new Rating(4, "Muy buena atención", new Date());
            myHotel.addRating(validRating);
            System.out.println("Puntuación agregada exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // 9. PRUEBA DE RESERVAS
        System.out.println("--- Prueba de Gestión de Reservas ---");
        Reservation reservation = new Reservation(new Date(), new Date(), room303);
        System.out.println("Reserva creada para habitación: " + room303.getRoomDescription());
        System.out.println("Estado inicial: " + reservation.getStatus());
        
        reservation.confirm();
        System.out.println("Estado actual: " + reservation.getStatus());
        
        reservation.finish();
        System.out.println("Estado final: " + reservation.getStatus());
        System.out.println();

        // 10. CÁLCULO DE PROMEDIO DE ESTRELLAS
        System.out.println("--- Cálculo de Promedio de Estrellas ---");
        myHotel.addRating(new Rating(5, "Excelente servicio", new Date()));
        myHotel.addRating(new Rating(3, "Regular", new Date()));
        System.out.println("Promedio de estrellas del hotel: " + myHotel.calculateAverageStars());
        

        System.out.println("\n========================================");
        System.out.println("  FIN DE LA EJECUCIÓN DEL SISTEMA");
        System.out.println("========================================");
    }
}