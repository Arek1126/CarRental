package com.arek1126.carrent.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Car {
    private String registrationNumber;
    private String brand;
    private String model;
    private int productionYear;
    private String color;
    private int mileage;
    private double pricePerDay;
}
