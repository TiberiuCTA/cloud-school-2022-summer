package com.spring.boot2.boot2proj.service;

import com.spring.boot2.boot2proj.dto.CarDTO;
import com.spring.boot2.boot2proj.mapper.CarMapper;
import com.spring.boot2.boot2proj.model.Car;
import com.spring.boot2.boot2proj.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarMapper carMapper;

    private final CarRepository carRepository;

    public List<CarDTO> getAllCars(){
        return carRepository.findAll().stream()
                .map(carMapper::toCarDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id){
        carRepository.deleteById(id);
    }

    public Car save(Car c){
        return carRepository.save(c);
    }


    public CarDTO getById(Integer id){
        return carMapper.toCarDTO(carRepository.findById(id).get());
    }
}
