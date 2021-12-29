package com.example.minitest2912.service;

import com.example.minitest2912.model.House;

public interface IHouseService extends IGeneralService <House>{
    Iterable<House> findAllByBathroomGrt(int number);
    Iterable<House> findAllByCategoryId(Long id);
}
