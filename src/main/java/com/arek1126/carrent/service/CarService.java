package com.arek1126.carrent.service;

import com.arek1126.carrent.exception.CarAlreadyExistsException;
import com.arek1126.carrent.exception.CarNotFoundException;
import com.arek1126.carrent.model.Car;
import com.arek1126.carrent.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findByRegistrationNumber(String registrationNumber){
        return carRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(CarNotFoundException::new);
    }

    public Car save(Car car){
        return carRepository.save(car)
                .orElseThrow(CarAlreadyExistsException::new);
    }


    public void deleteByRegistrationNumber(String registrationNumber){
        if (!carRepository.deleteByRegistrationNumber(registrationNumber))
            throw new CarNotFoundException();
    }

    public Car modifyCar(Car car){
        return carRepository.modifyCar(car)
                .orElseThrow(CarNotFoundException::new);
    }

    public List<Car> getBrand(String brand){
        List<Car> carList = carRepository.getBrand(brand);
        if(carList.isEmpty()){
            throw new CarNotFoundException();
        }
        return carList;
    }


}
