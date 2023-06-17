package com.lab.service;

import com.lab.domain.Car;

import java.util.List;

/**
 * The CarService interface, which stores the business logic for working with a car.
 */
public interface CarService {
    Car findCheapestCar();

    void printInfo(Car car);

    List<Car> sortCarsByReleaseYearDesc();

    Car findCarByRegistrationNumber();

    Car updateCarPrice(Car car);
}
