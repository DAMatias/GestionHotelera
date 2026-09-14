package com.hotelmanagement.model;

import java.util.Date;

public class Rating {
    private int value;
    private String comment;
    private Date date;

    public Rating(int value, String comment, Date date) {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Rating value must be between 1 and 5.");
        }
        this.value = value;
        this.comment = comment;
        this.date = date;
    }

    // ===== GETTERS =====
    public int getValue() {
        return value;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }

    // ===== SETTERS =====
    public void setValue(int value) {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Rating value must be between 1 and 5.");
        }
        this.value = value;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // ===== MÉTODO ADICIONAL =====
    public boolean isValid() {
        return value >= 1 && value <= 5;
    }
}