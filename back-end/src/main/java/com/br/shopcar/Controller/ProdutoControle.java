package com.br.shopcar.Controller;

import com.br.shopcar.Repository.ProdutoRepositorio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoControle {
    private ProdutoRepositorio acao;
}
