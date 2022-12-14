package com.br.shopcar.Model.Announcement;

import com.br.shopcar.Dto.GET.Comment.CommentAnswerDto;
import com.br.shopcar.Model.User.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class CommentAnswer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne
    private Comment comment;
    private String message;
    @CreationTimestamp
    private Timestamp timeCreated;

    public CommentAnswerDto convertToDto(){
        CommentAnswerDto commentAnswerDto = new CommentAnswerDto();
        commentAnswerDto.setUser(this.getUser().converterDto());
        commentAnswerDto.setMessage(this.getMessage());
        commentAnswerDto.setTimeCreated(this.getTimeCreated());
        return commentAnswerDto;
    }
}
