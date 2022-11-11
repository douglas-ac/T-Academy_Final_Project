package br.com.projeto_final.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_final.repository.CarRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cars")
public class CarController {
    private CarController action;
}
