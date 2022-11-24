package com.br.shopcar.Repository;

import com.br.shopcar.Model.Announcement.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Query(value = "select * from announcement a join product_model p where a.product_id = p.id and p.product_type = 1",
    nativeQuery = true)
    Page<Announcement> findAllAnnouncesCar(Pageable pageable);

    @Query(value = "select * from announcement a join product_model p where a.product_id = p.id and p.product_type = 2",
            nativeQuery = true)
    Page<Announcement> findAllAnnouncesParts(Pageable pageable);
}
