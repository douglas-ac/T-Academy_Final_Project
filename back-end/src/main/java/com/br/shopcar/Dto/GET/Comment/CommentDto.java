package com.br.shopcar.Dto.GET.Comment;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.Announcement.Comment;
import com.br.shopcar.Model.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class CommentDto {

    private long id;
    @NotBlank @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserDto user;
    @NotBlank @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AnnouncementDto announcement;

    @NotBlank
    private String message;

    private List<CommentAnswerDto> commentAnswerDtos = new ArrayList<>();

    public Comment convertToModel(){
        Comment comment = new Comment();
        comment.setId(this.getId());
        comment.setUser(user.convertToModel());
        comment.setAnnouncement(announcement.convertToModel());
        comment.setMessage(this.getMessage());
        comment.setAnswers(this.getCommentAnswerDtos().stream()
                .map(CommentAnswerDto::convertToModel)
                .collect(Collectors.toList()));
        return comment;
    }

    public Comment convertToModel(User userModel, Announcement announceModel) {
        Comment comment = new Comment();
        comment.setId(this.getId());
        comment.setUser(userModel);
        comment.setAnnouncement(announceModel);
        comment.setMessage(this.getMessage());
        comment.setAnswers(this.getCommentAnswerDtos().stream()
                .map(CommentAnswerDto::convertToModel)
                .collect(Collectors.toList()));
        return comment;
    }
}
