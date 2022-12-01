package com.br.shopcar.Repository;

import com.br.shopcar.Model.Announcement.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Images, Long> {

    Optional<Images> findByName(String name);
}
