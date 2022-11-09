package com.br.shopcar.Dto;

import com.br.shopcar.Dto.Slim.UserDtoSlim;
import com.br.shopcar.Model.Announcement.Announcement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnnouncementDto {

    private long id;
    private UserDtoSlim user;
    private Integer amount;
    private LocalDateTime date;

    public Announcement convertToModel(){
        Announcement announcement = new Announcement();
        announcement.setId(this.getId());
        announcement.setUser(this.getUser().convertToModel());
        announcement.setAmount(this.getAmount());
        announcement.setDate(this.getDate());
        return announcement;
    }
}
