package com.br.shopcar.Repository;

import com.br.shopcar.Model.OrderModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends CrudRepository<OrderModel, Long> {

    List<Optional<OrderModel>> findByUserId(long id);
}
