package com.br.shopcar.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.shopcar.Model.CarModel;

@Repository
public interface CarRepository extends CrudRepository<CarModel, Long> {
    
}
