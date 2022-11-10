package com.br.shopcar.Dto;

import com.br.shopcar.Dto.Slim.UserDtoSlim;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.Announcement.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnnouncementDto {

    private long id;
    @NotBlank
    private UserDtoSlim user;
    @NotBlank
    private Integer amount;
    private LocalDateTime date;
    private List<Comment> comments;

    public Announcement convertToModel(){
        Announcement announcement = new Announcement();
        announcement.setId(this.getId());
        announcement.setUser(this.getUser().convertToModel());
        announcement.setAmount(this.getAmount());
        announcement.setDate(this.getDate());
        return announcement;
    }
}
