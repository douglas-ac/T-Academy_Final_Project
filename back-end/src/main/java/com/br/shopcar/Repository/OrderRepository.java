package br.com.projeto_final.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_final.model.OrderModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderRepository, Long> {
    
}
