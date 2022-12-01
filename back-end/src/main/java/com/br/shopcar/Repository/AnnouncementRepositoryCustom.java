package com.br.shopcar.Repository;

import com.br.shopcar.Model.Announcement.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedHashMap;
import java.util.List;

public interface AnnouncementRepositoryCustom {
    Page<Announcement> filterCarAnnounceByCriteria(Pageable pageable, LinkedHashMap filters);
}
