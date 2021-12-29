package com.example.minitest2912.repository;

import com.example.minitest2912.model.Category;
import com.example.minitest2912.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHouseRepository extends JpaRepository <House, Long> {
    Iterable <House> findAllByBathroomGreaterThan(int number);
    Iterable <House> findAllByOrderByName();
    Iterable <House> findAllByCategory(Category category);
}
