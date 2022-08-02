package com.spring.boot2.boot2proj.controller;

import com.spring.boot2.boot2proj.dto.CarDTO;
import com.spring.boot2.boot2proj.model.Car;
import com.spring.boot2.boot2proj.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("car")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("{id}")
    public CarDTO getById(@PathVariable Integer id){
        return carService.getById(id);
    }

    @PostMapping
    public Car save(@RequestBody Car car){
        return carService.save(car);
    }

    @DeleteMapping
    public void deleteCar(Integer id){
        carService.deleteById(id);
    }
}
