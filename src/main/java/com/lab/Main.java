package com.lab;

import com.lab.domain.Car;
import com.lab.exception.NotFoundException;
import com.lab.repository.impl.CarRepositoryImpl;
import com.lab.service.CarService;
import com.lab.service.impl.CarServiceImpl;

import java.util.InputMismatchException;
import java.util.List;

/**
 * The main class of this application.
 */
public class Main {

    public static void main(String[] args) {

        CarService carService = new CarServiceImpl(new CarRepositoryImpl());

        try {
            // Определяем самый дешевый автомобиль
            System.out.println("The cheapest car:");
            Car car = carService.findCheapestCar();
            carService.printInfo(car);

            // Сортируем массив по года выпуска по убыванию
            System.out.println("Cars sorted by year of manufacture(desc):");
            List<Car> sortedCarsByReleaseYearDesc = carService.sortCarsByReleaseYearDesc();
            sortedCarsByReleaseYearDesc.forEach(carService::printInfo);

            // Ищем автомобиль по регистрационному номеру,
            Car carByRegistrationNumber = carService.findCarByRegistrationNumber();
            carService.printInfo(carByRegistrationNumber);

            // Изменяем стоимость и выводим информацию об автомобиле
            Car updateCarPrice = carService.updateCarPrice(carByRegistrationNumber);
            System.out.println("Information about car after change:");
            carService.printInfo(updateCarPrice);

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Enter a double value. For example: 120,20");
        }

    }
}
