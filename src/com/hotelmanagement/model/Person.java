package com.hotelmanagement.model;

import java.util.Date;
import java.util.Calendar;

public abstract class Person implements ICalculateAge {
    protected String name;
    protected String lastName;
    protected String dni;
    protected Date birthDate;

    public Person(String name, String lastName, String dni, Date birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.birthDate = birthDate;
    }

    // ===== GETTERS =====
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDni() {
        return dni;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    // ===== SETTERS =====
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // ===== MÉTODO DE INTERFAZ =====
    @Override
    public int calculateAge(Date birthDate) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
            age--;
        }
        return age;
    }

    // ===== MÉTODO ABSTRACTO =====
    public abstract void printRoleDetails();
}