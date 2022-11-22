package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.CarDto;
import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Dto.POST.UserDtoPost;
import com.br.shopcar.Repository.CarRepository;
import com.br.shopcar.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/cars")
public class CarController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<CarDto>> findAllCars(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllCars());
    }

    @GetMapping("/{idCar}")
    public ResponseEntity<CarDto> findById(@PathVariable("idCar") long idCar){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findCarById(idCar));
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto carDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(carDto));
    }
    @DeleteMapping("/{idCar}")
    public ResponseEntity<Void> delete(@PathVariable("idCar") long idCar){
        productService.deleteCarById(idCar);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
