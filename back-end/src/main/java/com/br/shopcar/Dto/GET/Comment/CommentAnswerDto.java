package com.br.shopcar.Dto.GET.Comment;

import com.br.shopcar.Model.Announcement.Comment;
import com.br.shopcar.Model.Announcement.CommentAnswer;
import com.br.shopcar.Model.User.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
public class CommentAnswerDto {

    private long idCommentAnswer;
    @NotBlank
    private long userId;
    @NotBlank
    private String message;
    @NotBlank
    private long commentId;
    private Timestamp timeCreated;

    public CommentAnswer convertToModel(User user, Comment comment){
        CommentAnswer commentAnswer = new CommentAnswer();
        commentAnswer.setId(this.getIdCommentAnswer());
        commentAnswer.setUser(user);
        commentAnswer.setMessage(this.getMessage());
        commentAnswer.setComment(comment);
        commentAnswer.setTimeCreated(this.getTimeCreated());
        return commentAnswer;
    }
}
