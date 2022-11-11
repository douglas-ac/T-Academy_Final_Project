package com.br.shopcar.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.shopcar.Model.PartModel;

@Repository
public interface PartRepository extends CrudRepository<PartModel, Long> {
    
}
