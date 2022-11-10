package com.br.shopcar.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_final.modelo.CarrinhoModelo;

@Repository
public interface CarrinhoRepositorio extends CrudRepository<CarrinhoModelo, Long> {
    
}
