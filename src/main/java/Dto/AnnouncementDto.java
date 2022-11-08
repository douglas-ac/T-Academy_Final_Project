package Dto;

import Dto.Slim.UserDtoSlim;
import Model.Announcement.Announcement;
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

}
