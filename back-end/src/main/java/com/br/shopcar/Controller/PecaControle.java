package com.br.shopcar.Controller;

import com.br.shopcar.Repository.PecaRepositorio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pecas")
public class PecaControle {
    private PecaRepositorio acao;
}
