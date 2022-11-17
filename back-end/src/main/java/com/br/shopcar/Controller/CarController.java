package com.br.shopcar.Controller;

import com.br.shopcar.Repository.CarRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cars")
public class CarController {
    private CarRepository acao;
}
