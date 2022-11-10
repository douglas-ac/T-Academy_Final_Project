package br.com.projeto_final.controle;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_final.repositorio.ProdutoRepositorio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoControle {
    private ProdutoRepositorio acao;
}
