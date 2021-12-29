package com.example.minitest2912.controller;

import com.example.minitest2912.model.Category;
import com.example.minitest2912.model.House;
import com.example.minitest2912.service.ICategoryService;
import com.example.minitest2912.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    public IHouseService houseService;

    @Autowired
    public ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }


    @GetMapping
    public ResponseEntity<Iterable<House>> findAll() {
        Iterable<House> houses = houseService.findAll();
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> findById(@PathVariable Long id){
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(houseOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<House> add(@RequestBody House house){
        return new ResponseEntity<>(houseService.save(house),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<House> remove(@PathVariable Long id){
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        houseService.remove(id);
        return new  ResponseEntity<>(houseOptional.get(),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> update(@RequestBody House house, @PathVariable Long id){
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        house.setId(id);
        return new  ResponseEntity<>(houseService.save(house),HttpStatus.OK);
    }

    @GetMapping("/bathroom-grt-2")
    public ResponseEntity<Iterable<House>> findBathroomGrt2() {
        Iterable<House> houses = houseService.findAllByBathroomGrt(2);
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<House>> findByCategory(@PathVariable Long id) {
        Iterable<House> houses = houseService.findAllByCategoryId(id);
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }
    @GetMapping("/order-by-name")
    public ResponseEntity<Iterable<House>> orderByName() {
        Iterable<House> houses = houseService.orderByName();
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }




}
