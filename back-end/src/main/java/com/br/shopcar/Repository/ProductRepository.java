package br.com.projeto_final.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_final.model.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductRepository, Long> {
    
}
