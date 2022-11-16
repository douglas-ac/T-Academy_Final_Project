package com.br.shopcar.Repository;

import com.br.shopcar.Model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {
    
}
