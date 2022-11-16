package com.br.shopcar.Controller;

import com.br.shopcar.Repository.CarrinhoRepositorio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carrinhos")
public class CarrinhoControle {
    private CarrinhoRepositorio acao;
}
