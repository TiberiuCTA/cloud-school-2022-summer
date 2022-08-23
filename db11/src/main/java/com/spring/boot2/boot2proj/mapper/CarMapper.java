package com.spring.boot2.boot2proj.mapper;

import com.spring.boot2.boot2proj.dto.CarDTO;
import com.spring.boot2.boot2proj.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDTO toCarDTO(Car car);
}
