package com.br.shopcar.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.shopcar.Repository.CarRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cars")
public class CarController {
    private CarController action;
}
