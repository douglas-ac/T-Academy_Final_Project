package com.br.shopcar.Repository;

import com.br.shopcar.Model.CarrinhoModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarrinhoRepositorio extends CrudRepository<CarrinhoModelo, Long> {
    
}
