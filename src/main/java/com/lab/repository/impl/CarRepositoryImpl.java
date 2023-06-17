package com.lab.repository.impl;

import com.lab.domain.Car;
import com.lab.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * CarRepository implementation.
 */
public class CarRepositoryImpl implements CarRepository {

    /**
     * Создание списка объектов класса Car
     */
    @Override
    public List<Car> findAllCars() {
        return new ArrayList<>() {{
            add(new Car("Toyota Camry", "A123BC", 2015, 100000, 10000));
            add(new Car("Honda Civic", "B456DE", 2010, 150000, 8000));
            add(new Car("Nissan Altima", "C789FG", 2018, 50000, 12000));
        }};
    }
}
