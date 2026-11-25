package com.arek1126.carrent.service;

import com.arek1126.carrent.model.Car;
import com.arek1126.carrent.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CarServiceTest {
CarService carService;
CarRepository carRepository;

    @BeforeEach
    void setup(){
        this.carRepository = Mockito.mock(CarRepository.class);
        this.carService = new CarService(carRepository);
    }

    @Test
    void getCars_DataCorrect_CarsReturned(){
        //given
        List<Car> cars = List.of(new Car("WA12345", "Toyota", "Corolla", 2022, "white", 35000, 150.0), new Car("KR67890", "BMW", "320d", 2020, "black", 65000, 250.0));
        when(carRepository.findAll()).thenReturn(cars);
        //when
        List<Car> result = carService.findAll();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, result.size()),
                () -> Assertions.assertEquals("WA12345", result.get(0).getRegistrationNumber()),
                () -> Assertions.assertEquals("Toyota", result.get(0).getBrand()),
                () -> Assertions.assertEquals("Corolla", result.get(0).getModel()),
                () -> Assertions.assertEquals(2022, result.get(0).getProductionYear()),
                () -> Assertions.assertEquals("white", result.get(0).getColor()),
                () -> Assertions.assertEquals(35000, result.get(0).getMileage()),
                () -> Assertions.assertEquals(150.0, result.get(0).getPricePerDay()),
                () -> Assertions.assertEquals("KR67890", result.get(1).getRegistrationNumber()),
                () -> Assertions.assertEquals("BMW", result.get(1).getBrand()),
                () -> Assertions.assertEquals("320d", result.get(1).getModel()),
                () -> Assertions.assertEquals(2020, result.get(1).getProductionYear()),
                () -> Assertions.assertEquals("black", result.get(1).getColor()),
                () -> Assertions.assertEquals(65000, result.get(1).getMileage()),
                () -> Assertions.assertEquals(250.0, result.get(1).getPricePerDay())
        );
    }

    @Test
    void getByRegistrationNumber_DataCorrect_CarReturned(){
        //given
        Car car = new Car("WA12345", "Toyota", "Corolla", 2022, "white", 35000, 150.0);
        when(carRepository.findByRegistrationNumber("WA12345")).thenReturn(Optional.of(car));
        //when
        Car result = carService.findByRegistrationNumber("WA12345");
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals("WA12345", result.getRegistrationNumber()),
                () -> Assertions.assertEquals("Toyota", result.getBrand()),
                () -> Assertions.assertEquals("Corolla", result.getModel()),
                () -> Assertions.assertEquals(2022, result.getProductionYear()),
                () -> Assertions.assertEquals("white", result.getColor()),
                () -> Assertions.assertEquals(35000, result.getMileage()),
                () -> Assertions.assertEquals(150.0, result.getPricePerDay())
        );
    }

    @Test
    void addCar_DataCorrect_CarReturned(){
        //given
        Car car = new Car("WA12345", "Toyota", "Corolla", 2022, "white", 35000, 150.0);
        when(carRepository.save(car)).thenReturn(Optional.of(car));
        //when
        Car result = carService.save(car);
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals("WA12345", result.getRegistrationNumber()),
                () -> Assertions.assertEquals("Toyota", result.getBrand()),
                () -> Assertions.assertEquals("Corolla", result.getModel()),
                () -> Assertions.assertEquals(2022, result.getProductionYear()),
                () -> Assertions.assertEquals("white", result.getColor()),
                () -> Assertions.assertEquals(35000, result.getMileage()),
                () -> Assertions.assertEquals(150.0, result.getPricePerDay())
        );
    }

    @Test
    void modifyByRegistrationNumber_DataCorrect_CarReturned(){
        //given
        Car carsNewData = new Car("WA12345", "BMW", "320d", 2020, "black", 65000, 250.0);
        when(carRepository.modifyCar(carsNewData)).thenReturn(Optional.of(carsNewData));
        //when
        Car result = carService.modifyCar(carsNewData);
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals("WA12345", result.getRegistrationNumber()),
                () -> Assertions.assertEquals("BMW", result.getBrand()),
                () -> Assertions.assertEquals("320d", result.getModel()),
                () -> Assertions.assertEquals(2020, result.getProductionYear()),
                () -> Assertions.assertEquals("black", result.getColor()),
                () -> Assertions.assertEquals(65000, result.getMileage()),
                () -> Assertions.assertEquals(250.0, result.getPricePerDay())
        );
    }

    @Test
    void getBrand_DataCorrect_CarReturned(){
        //given
        List<Car> cars = List.of(new Car("WA12345", "Toyota", "Corolla", 2022, "white", 35000, 150.0));
        when(carRepository.getBrand("Toyota")).thenReturn(cars);
        //when
        List<Car> result = carService.getBrand("Toyota");
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals("WA12345", result.get(0).getRegistrationNumber()),
                () -> Assertions.assertEquals("Toyota", result.get(0).getBrand()),
                () -> Assertions.assertEquals("Corolla", result.get(0).getModel()),
                () -> Assertions.assertEquals(2022, result.get(0).getProductionYear()),
                () -> Assertions.assertEquals("white", result.get(0).getColor()),
                () -> Assertions.assertEquals(35000, result.get(0).getMileage()),
                () -> Assertions.assertEquals(150.0, result.get(0).getPricePerDay())
        );
    }
}
