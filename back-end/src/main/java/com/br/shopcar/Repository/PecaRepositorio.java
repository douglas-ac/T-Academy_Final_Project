package com.br.shopcar.Repository;

import com.br.shopcar.Model.PecaModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PecaRepositorio extends CrudRepository<PecaModelo, Long> {
    
}
