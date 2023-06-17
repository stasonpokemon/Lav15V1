package com.lab.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Car entity class.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String model;

    private String registrationNumber;

    private int releaseYear;

    private int mileage;

    private double price;
}
