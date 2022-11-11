package br.com.projeto_final.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_final.model.CarModel;

@Repository
public interface CarRepository extends CrudRepository<CarModel, Long> {
    
}
