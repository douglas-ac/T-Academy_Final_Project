package com.br.shopcar.Repository;

import com.br.shopcar.Model.PartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartRepository extends JpaRepository<PartModel, Long> {
    
}
