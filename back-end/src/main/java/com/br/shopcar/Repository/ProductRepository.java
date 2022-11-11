package com.br.shopcar.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.shopcar.Model.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductRepository, Long> {
    
}
