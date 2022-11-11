package com.br.shopcar.Dto.GET.Comment;

import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.Announcement.Comment;
import com.br.shopcar.Model.User.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class CommentDto {

    private long id;
    @NotBlank
    private long userId;
    @NotBlank
    private long announceId;
    @NotBlank
    private String message;
    private List<CommentAnswerDto> commentAnswerDtos = new ArrayList<>();

    public Comment convertToModel(User user, Announcement announcement){
        Comment comment = new Comment();
        comment.setId(this.getId());
        comment.setUser(user);
        comment.setAnnouncement(announcement);
        comment.setMessage(this.getMessage());
        return comment;
    }

}
