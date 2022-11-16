package com.br.shopcar.Repository;

import com.br.shopcar.Model.CarroModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepositorio extends CrudRepository<CarroModelo, Long> {
    
}
