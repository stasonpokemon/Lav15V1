package com.lab.service.impl;

import com.lab.domain.Car;
import com.lab.exception.NotFoundException;
import com.lab.repository.CarRepository;
import com.lab.service.CarService;


import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * CarService implementation.
 */
public class CarServiceImpl implements CarService {

    private final Scanner scanner = new Scanner(System.in);

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Поиск самого дешёвого автомобился.
     *
     * @return Car
     */
    @Override
    public Car findCheapestCar() {
        return carRepository.findAllCars().stream().min(Comparator.comparingDouble(Car::getPrice))
                .orElseThrow(() -> new NotFoundException(Car.class));
    }

    /**
     * Вывод информации об автомобиле в консль.
     */
    @Override
    public void printInfo(Car car) {
        System.out.println("    Модель: " + car.getModel());
        System.out.println("    Регистрационный номер: " + car.getRegistrationNumber());
        System.out.println("    Год выпуска: " + car.getReleaseYear());
        System.out.println("    Пробег: " + car.getMileage());
        System.out.println("    Стоимость: " + car.getPrice() + "\n");
    }

    /**
     * Сортировка списка автомобилей по дате выпуска по убыванию.
     *
     * @return List<Car>
     */
    @Override
    public List<Car> sortCarsByReleaseYearDesc() {
        return carRepository.findAllCars().stream()
                .sorted(Comparator.comparingInt(Car::getReleaseYear).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Поиск автомобиля по регистрационному номеру.
     *
     * @return Car
     */
    @Override
    public Car findCarByRegistrationNumber() {
        System.out.print("Enter the registration number of the car:");

        List<Car> cars = carRepository.findAllCars();

        String regNumber = scanner.nextLine();

        Car car = cars.stream()
                .filter(c -> c.getRegistrationNumber().equals(regNumber))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Not found car with specified registration number: %s"
                        .formatted(regNumber)));

        System.out.println("Found car:");

        return car;
    }

    /**
     * Обновление стоимости автомобиля.
     *
     * @param car - Автомобиль, которому нужно задать новую стоимость
     *
     * @return Car
     */
    @Override
    public Car updateCarPrice(Car car) {
        System.out.print("Enter the new price of the car: ");

        double newPrice = scanner.nextDouble();

        car.setPrice(newPrice);

        return car;
    }
}
