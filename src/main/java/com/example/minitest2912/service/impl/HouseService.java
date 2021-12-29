package com.example.minitest2912.service.impl;

import com.example.minitest2912.model.House;
import com.example.minitest2912.repository.ICategoryRepository;
import com.example.minitest2912.repository.IHouseRepository;
import com.example.minitest2912.service.ICategoryService;
import com.example.minitest2912.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService implements IHouseService {

    @Autowired
    public ICategoryRepository categoryRepository;

    @Autowired
    public IHouseRepository houseRepository;

    @Override
    public Iterable<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public House save(House house) {
        return houseRepository.save(house);
    }

    @Override
    public void remove(Long id) {
        houseRepository.deleteById(id);


    }

    @Override
    public Iterable<House> orderByName() {
        return houseRepository.findAllByOrderByName();
    }

    @Override
    public Iterable<House> findAllByBathroomGrt(int number) {
        return houseRepository.findAllByBathroomGreaterThan(number);
    }

    @Override
    public Iterable<House> findAllByCategoryId(Long id) {
        return houseRepository.findAllByCategory(categoryRepository.getById(id));
    }
}
