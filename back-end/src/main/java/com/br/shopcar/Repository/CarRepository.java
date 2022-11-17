package com.br.shopcar.Repository;

import com.br.shopcar.Model.CarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<CarModel, Long> {
    
}
