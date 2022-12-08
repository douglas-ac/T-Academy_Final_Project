package com.br.shopcar.Repository.dao;

import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Repository.AnnouncementRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public class AnnouncementRepositoryCustomImpl implements AnnouncementRepositoryCustom {

    private final EntityManager entityManager;

    @Autowired
    public AnnouncementRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager.getEntityManagerFactory().createEntityManager();
    }

    public String baseQueryAnnounce(int product_type, LinkedHashMap filters) {
        StringBuilder sb = new StringBuilder();

        sb.append("select * from announcement a left join product_model p on a.product_id = p.id WHERE p.product_type = ").append(product_type);
        if(filters.get("name") != null){
            sb.append(" and p.name like  '%").append(filters.get("name")).append("%'");
        }

        if(filters.get("location") != null){
            sb.append(" and (")
                    .append("(a.localidade like  '%").append(filters.get("location")).append("%')")
                            .append(" or ")
                    .append("(a.uf like  '%").append(filters.get("location")).append("%')")
                    .append(")");

        }

        if(filters.get("year") != null){
            Integer tmpYear = (Integer) ((LinkedHashMap) filters.get("year")).get("from");
            if(tmpYear != null){
                sb.append(" and p.year >= "+tmpYear);
            }
            tmpYear = (Integer) ((LinkedHashMap) filters.get("year")).get("to");
            if(tmpYear != null){
                sb.append(" and p.year <= "+tmpYear);
            }
        }

        if(filters.get("price") != null){
            Integer tmpPrice = (Integer) ((LinkedHashMap) filters.get("price")).get("from");
            if(tmpPrice != null){
                sb.append(" and p.price >= "+tmpPrice);
            }
            tmpPrice = (Integer) ((LinkedHashMap) filters.get("price")).get("to");
            if(tmpPrice != null){
                sb.append(" and p.price <= "+tmpPrice);
            }
        }

        if(filters.get("automaker") != null && ((ArrayList<String>) filters.get("automaker")).size()>0){
            ArrayList<String> tmpArr = (ArrayList<String>) filters.get("automaker");
            sb.append(" and p.automaker in ('").
                    append(String.join("', '", tmpArr))
                    .append("')");
        }

        if(filters.get("category") != null && ((ArrayList<String>) filters.get("category")).size()>0){
            ArrayList<String> tmpArr = (ArrayList<String>) filters.get("category");
            sb.append(" and p.category in ('").
                    append(String.join("', '", tmpArr))
                    .append("')");
        }

        return sb.toString();
    }
    @Override
    public Page<Announcement> filterCarAnnounceByCriteria(Pageable pageable, LinkedHashMap filters) {
        StringBuilder sb = new StringBuilder(baseQueryAnnounce(1, filters));

        if(filters.get("mileage") != null){
            Integer tmpMileage = (Integer) ((LinkedHashMap) filters.get("mileage")).get("from");
            if(tmpMileage != null){
                sb.append(" and p.quilometragem >= "+tmpMileage);
            }
            tmpMileage = (Integer) ((LinkedHashMap) filters.get("mileage")).get("to");
            if(tmpMileage != null){
                sb.append(" and p.quilometragem <= "+tmpMileage);
            }
        }

        if(filters.get("condition") != null && ((ArrayList<String>) filters.get("condition")).size()>0){
            ArrayList<String> tmpArr = (ArrayList<String>) filters.get("condition");
            String novo = "false";
            String usado = "false";
            if(tmpArr.contains("novo")){
                novo = "(p.quilometragem = 0)";
            }
            if(tmpArr.contains("usado")){
                usado = "(p.quilometragem > 0)";
            }
            sb.append(" and (")
                    .append(String.join(" or ", novo, usado))
                    .append(")");
        }

        if(filters.get("color") != null && ((ArrayList<String>) filters.get("color")).size()>0){
            ArrayList<String> tmpArr = (ArrayList<String>) filters.get("color");
            sb.append(" and p.color in ('").
                    append(String.join("', '", tmpArr))
                    .append("')");
        }

        Query q = entityManager.createNativeQuery(sb.toString(),Announcement.class);
        List<Announcement> rst = q.getResultList();
        return new PageImpl<Announcement>(rst, pageable, rst.size());
    }
    @Override
    public Page<Announcement> filterAutopartAnnounceByCriteria(Pageable pageable, LinkedHashMap filters) {
        StringBuilder sb = new StringBuilder(baseQueryAnnounce(2, filters));

        if(filters.get("part_condition") != null && ((ArrayList<String>) filters.get("part_condition")).size()>0){
            ArrayList<String> tmpArr = (ArrayList<String>) filters.get("part_condition");
            sb.append(" and p.part_condition in ('").
                    append(String.join("', '", tmpArr))
                    .append("')");
        }

        if(filters.get("brand") != null && ((ArrayList<String>) filters.get("brand")).size()>0){
            ArrayList<String> tmpArr = (ArrayList<String>) filters.get("brand");
            sb.append(" and p.brand in ('").
                    append(String.join("', '", tmpArr))
                    .append("')");
        }

        if(filters.get("vehicle_type") != null && ((ArrayList<String>) filters.get("vehicle_type")).size()>0){
            ArrayList<String> tmpArr = (ArrayList<String>) filters.get("vehicle_type");
            sb.append(" and p.vehicle_type in ('").
                    append(String.join("', '", tmpArr))
                    .append("')");
        }

        Query q = entityManager.createNativeQuery(sb.toString(),Announcement.class);
        List<Announcement> rst = q.getResultList();
        return new PageImpl<Announcement>(rst, pageable, rst.size());
    }
}
