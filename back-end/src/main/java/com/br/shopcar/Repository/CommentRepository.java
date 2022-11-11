package com.br.shopcar.Repository;

import com.br.shopcar.Model.Announcement.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Long> {
    Optional<List<Comment>> findByAnnouncementId(Long id);
}
