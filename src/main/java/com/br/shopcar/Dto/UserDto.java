package com.br.shopcar.Dto;

import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private LoginDto login;
    private List<AnnouncementDto> announcementList;
    private String nacionalNumber;
    private String descriminationColumn;

    public User convertToModel(){
        User user = new User();
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setBirthDate(this.getBirthDate());
        user.setLogin(this.getLogin().convertToModel());
        user.setAnnouncementList(this.announcementList
                .stream()
                .map(AnnouncementDto::convertToModel)
                .collect(Collectors.toList()));
        user.setNacionalNumber(this.getNacionalNumber());
        user.setDescriminationColumn(this.getDescriminationColumn());
        return user;
    }
}
