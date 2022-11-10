package com.br.shopcar.Controller;

import com.br.shopcar.Repository.CarroRepositorio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carros")
public class CarroControle {
    private CarroRepositorio acao;
}
