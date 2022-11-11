package com.br.shopcar.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.shopcar.Model.OrderModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderRepository, Long> {
    
}
