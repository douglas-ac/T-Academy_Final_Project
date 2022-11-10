package com.br.shopcar.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_final.repositorio.CarroRepositorio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carros")
public class CarroControle {
    private CarroRepositorio acao;
}
