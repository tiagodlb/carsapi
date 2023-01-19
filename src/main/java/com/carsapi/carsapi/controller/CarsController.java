package com.carsapi.carsapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.carsapi.dto.CarDTO;
import com.carsapi.carsapi.model.carModel;
import com.carsapi.carsapi.repository.carsRepository;

import jakarta.validation.Valid;

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
   public void create(@RequestBody @Valid CarDTO req){
        repository.save(new carModel(req));
   }

   @PutMapping("/{id}")
   public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req){
      repository.findById(id).map(car -> {
         car.setModelo(req.modelo());
         car.setFabricante(req.fabricante());
         car.setDataFabricacao(req.dataFabricacao());
         car.setValor(req.valor());
         car.setAnoModelo(req.anoModelo());

         return repository.save(car);
      });
   }

   @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id){
      repository.deleteById(id);

   }
}
