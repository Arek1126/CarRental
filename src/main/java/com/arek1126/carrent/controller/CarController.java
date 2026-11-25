package com.arek1126.carrent.controller;

import com.arek1126.carrent.model.Car;
import com.arek1126.carrent.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> findAll(){
        return carService.findAll();
    }

    @GetMapping("/{registrationNumber}")
    public Car findByRegistrationNumber(@PathVariable String registrationNumber){
        return carService.findByRegistrationNumber(registrationNumber);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
       return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(car));
    }

    @DeleteMapping("/{registrationNumber}")
    public ResponseEntity<Void> deleteByRegistrationNumber(@PathVariable String registrationNumber){
        carService.deleteByRegistrationNumber(registrationNumber);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{registrationNumber}")
    public Car modifyByRegistrationNumber(@PathVariable String registrationNumber, @RequestBody Car car){
        return carService.modifyCar(car);
    }

    @GetMapping("/brands/{brand}")
    public List<Car> getBrand(@PathVariable String brand){
        return carService.getBrand(brand);
    }
}
