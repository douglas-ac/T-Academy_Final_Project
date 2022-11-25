package com.br.shopcar.Repository;

import com.br.shopcar.Model.PartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PartRepository extends JpaRepository<PartModel, Long> {

    List<PartModel> findByNameContains(String name);
}
