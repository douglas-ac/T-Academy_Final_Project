package com.br.shopcar.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_final.repositorio.PecaRepositorio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pecas")
public class PecaControle {
    private PecaRepositorio acao;
}
