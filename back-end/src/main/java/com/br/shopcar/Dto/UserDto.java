package com.br.shopcar.Dto;

import com.br.shopcar.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private LocalDate birthDate;
    @NotBlank
    private LoginDto login;
    private List<AnnouncementDto> announcementList;
    @NotBlank
    private String nacionalNumber;
    @NotBlank
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

    public User convertToModelPost(){
        User user = new User();
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setBirthDate(this.getBirthDate());
        user.setLogin(this.getLogin().convertToModel());
        user.setNacionalNumber(this.getNacionalNumber());
        user.setDescriminationColumn(this.getDescriminationColumn());
        return user;
    }
}
