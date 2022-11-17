package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.CarDto;
import com.br.shopcar.Dto.POST.CarDtoPost;
import com.br.shopcar.Repository.CarRepository;
import com.br.shopcar.Service.CarService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAll());
    }

    @GetMapping("/{idCar}")
    public ResponseEntity<CarDto> findById(@PathVariable("idCar") long idCar){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findById(idCar));
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDtoPost carDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(carDtoPost));
    }

    @PutMapping("/{idCar}")
    public ResponseEntity<CarDto> change(@PathVariable("idCar") long idCar,
    @RequestBody CarDto CarDto){
        return ResponseEntity.status(HttpStatus.OK).body(carService.change(idCar, CarDto));
    }

    @DeleteMapping("/{idCar}")
    public ResponseEntity<Void> delete(@PathVariable("idCar") long idCar){
        carService.delete(idCar);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
