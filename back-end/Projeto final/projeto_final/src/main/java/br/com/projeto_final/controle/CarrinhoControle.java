package br.com.projeto_final.controle;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_final.repositorio.CarrinhoRepositorio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carrinhos")
public class CarrinhoControle {
    private CarrinhoRepositorio acao;
}
