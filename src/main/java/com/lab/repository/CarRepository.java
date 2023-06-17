package com.lab.repository;

import com.lab.domain.Car;

import java.util.List;

/**
 * The CarRepository interface, which stores data about cars.
 */
public interface CarRepository {

    List<Car> findAllCars();
}
