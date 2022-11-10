package com.br.shopcar.Repository;

import com.br.shopcar.Model.Announcement.Comment;
import com.br.shopcar.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Long> {
    Optional<Comment> findByAnnouncementId(Long id);
}
