package com.carsapi.carsapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.carsapi.dto.CarDTO;
import com.carsapi.carsapi.model.carModel;
import com.carsapi.carsapi.repository.carsRepository;

@RestController
@RequestMapping("/cars")
public class CarsController {

   @Autowired
   private carsRepository repository;

   @GetMapping
   public List<carModel> listAll(){
      return repository.findAll();
   }

   @PostMapping
   public void create(@RequestBody CarDTO req){
        repository.save(new carModel(req));
   }
}
