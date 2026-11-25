package com.arek1126.carrent.repository;

import com.arek1126.carrent.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CarRepository {
    private final List<Car> cars = new ArrayList<>(List.of(
            new Car("WA12345", "Toyota", "Corolla", 2022, "white", 35000, 150.0),
            new Car("KR67890", "BMW", "320d", 2020, "black", 65000, 250.0),
            new Car("PO11111", "Opel", "Astra", 2019, "silver", 80000, 120.0)
    ));

    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }

    public Optional<Car> findByRegistrationNumber(String registrationNumber) {
        return cars.stream()
                .filter(car -> car.getRegistrationNumber().equalsIgnoreCase(registrationNumber))
                .findFirst();
    }

    public Optional<Car> save(Car car) {
        if (findByRegistrationNumber(car.getRegistrationNumber()).isPresent()) {
            return Optional.empty();
        }
        cars.add(car);
        return Optional.of(car);
    }

    public boolean deleteByRegistrationNumber(String registrationNumber) {
        return findByRegistrationNumber(registrationNumber)
                .map(cars::remove)
                .orElse(false);
    }

    public Optional<Car> modifyCar(Car car) {
        Optional<Car> modifiedCar = findByRegistrationNumber(car.getRegistrationNumber());
        if (modifiedCar.isPresent()) {
            modifiedCar.get().setBrand(car.getBrand());
            modifiedCar.get().setColor(car.getColor());
            modifiedCar.get().setMileage(car.getMileage());
            modifiedCar.get().setProductionYear(car.getProductionYear());
            modifiedCar.get().setPricePerDay(car.getPricePerDay());
        }
        return modifiedCar;
    }

    public List<Car> getBrand(String brand){
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

}
