package com.br.shopcar.Dto.GET;

import com.br.shopcar.Dto.GET.Slim.AnnouncementSlim;
import com.br.shopcar.Model.Announcement.Address;
import com.br.shopcar.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
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
    private String birthDate;
    @NotBlank
    private LoginDto login;
    private List<AnnouncementSlim> announcementList = new ArrayList<>();
    @NotBlank
    private String nacionalNumber;
    @NotBlank
    private String descriminationColumn;
    @NotBlank
    private String fone;
    private Address address;

    public User convertToModel(){
        User user = new User();
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setBirthDate(this.getBirthDate());
        user.setLogin(this.getLogin().convertToModel());
        user.setAnnouncementList(this.announcementList
                .stream()
                .map(AnnouncementSlim::convertToModel)
                .collect(Collectors.toList()));
        user.setNacionalNumber(this.getNacionalNumber());
        user.setDescriminationColumn(this.getDescriminationColumn());
        user.setFone(this.getFone());
        user.setAddress(this.getAddress());
        return user;
    }
}
