package com.br.shopcar.Model.Announcement;

import com.br.shopcar.Dto.GET.Comment.CommentDto;
import com.br.shopcar.Model.User.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne
    private Announcement announcement;
    private String message;
    @OneToMany(mappedBy = "comment")
    private List<CommentAnswer> answers = new ArrayList<>();
    @CreationTimestamp
    private Timestamp time;

    public CommentDto convertToDto(){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(this.getId());
        commentDto.setUser(this.getUser().converterDto());
        commentDto.setMessage(this.getMessage());
        commentDto.setCommentAnswerDtos(this.getAnswers()
                .stream()
                .map(CommentAnswer::convertToDto)
                .collect(Collectors.toList()));
        return commentDto;
    }
}
