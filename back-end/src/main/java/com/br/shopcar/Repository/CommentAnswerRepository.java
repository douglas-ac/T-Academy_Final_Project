package com.br.shopcar.Repository;

import com.br.shopcar.Model.Announcement.CommentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentAnswerRepository extends JpaRepository<CommentAnswer , Long> {
    Optional<List<CommentAnswer>> findByCommentId(long id);
}
