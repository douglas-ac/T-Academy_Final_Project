package com.br.shopcar.Model.User;

import com.br.shopcar.Dto.GET.Slim.UserDtoSlim;
import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Model.Announcement.Adress;
import com.br.shopcar.Model.Announcement.Announcement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String birthDate;
    @Embedded
    private Login login;
    @OneToMany(mappedBy = "user")
    private List<Announcement> announcementList = new ArrayList<>();
    private String nacionalNumber; //NUMERO IDENTIFICADOR(CPF OU CNPJ)
    private String descriminationColumn; //STRING DESCRIMINATORIA (CPF OU CNPJ)
    private String fone;
    private Adress adress;

    public UserDto converterDto(){
        UserDto userDto = new UserDto();
        userDto.setId(this.getId());
        userDto.setName(this.getName());
        userDto.setEmail(this.getEmail());
        userDto.setBirthDate(this.getBirthDate());
        userDto.setLogin(this.login.converter());
        userDto.setAnnouncementList(this.announcementList
                .stream()
                .map(Announcement::converter)
                .collect(Collectors.toList()));
        userDto.setNacionalNumber(this.getNacionalNumber());
        userDto.setDescriminationColumn(this.getDescriminationColumn());
        return userDto;
    }

    public UserDtoSlim converterDtoSlim(){
        UserDtoSlim userDtoSlim = new UserDtoSlim();
        userDtoSlim.setId(this.getId());
        userDtoSlim.setName(this.getName());
        userDtoSlim.setEmail(this.getEmail());
        userDtoSlim.setBirthDate(this.getBirthDate());
        userDtoSlim.setNacionalNumber(this.getNacionalNumber());
        return userDtoSlim;
    }

}
