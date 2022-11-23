package com.br.shopcar.Repository;

import com.br.shopcar.Model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {

    List<CarModel> findByNomeContains(String name);
}
