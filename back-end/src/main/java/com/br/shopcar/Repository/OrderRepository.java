package com.br.shopcar.Repository;

import com.br.shopcar.Model.OrderModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<OrderModel, Long> {
    
}
