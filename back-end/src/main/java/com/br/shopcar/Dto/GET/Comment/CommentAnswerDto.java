package com.br.shopcar.Dto.GET.Comment;

import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Model.Announcement.Comment;
import com.br.shopcar.Model.Announcement.CommentAnswer;
import com.br.shopcar.Model.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
public class CommentAnswerDto {

    private long idCommentAnswer;

    @NotBlank @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserDto user;

    @NotBlank
    private String message;

    @NotBlank @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CommentDto comment;

    private Timestamp timeCreated;
    public CommentAnswer convertToModel(){
        CommentAnswer commentAnswer = new CommentAnswer();
        commentAnswer.setId(this.getIdCommentAnswer());
        commentAnswer.setUser(this.getUser().convertToModel());
        commentAnswer.setMessage(this.getMessage());
        commentAnswer.setComment(this.getComment().convertToModel());
        commentAnswer.setTimeCreated(this.getTimeCreated());
        return commentAnswer;
    }

    public CommentAnswer convertToModel(User user, Comment comment){
        CommentAnswer commentAnswer = new CommentAnswer();
        commentAnswer.setUser(user);
        commentAnswer.setMessage(this.getMessage());
        commentAnswer.setComment(comment);
        commentAnswer.setTimeCreated(this.getTimeCreated());
        return commentAnswer;
    }
}
