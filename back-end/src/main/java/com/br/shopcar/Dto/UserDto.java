package com.br.shopcar.Dto;

import com.br.shopcar.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    @NotBlank @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$")
    private String birthDate;
    @NotBlank
    private LoginDto login;
    private List<AnnouncementDto> announcementList;
    @NotBlank
    private String nacionalNumber;
    @NotBlank
    private String descriminationColumn;
    @NotBlank @Pattern(regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")
    private String fone;

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
        user.setFone(this.getFone());
        return user;
    }
}
