package com.br.shopcar.Repository;

import com.br.shopcar.Model.Announcement.CommentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentAnswerRepository extends JpaRepository<CommentAnswer , Long> {
}
