package com.br.shopcar.Dto.POST;

import com.br.shopcar.Dto.LoginDto;
import com.br.shopcar.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDtoPost {

    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private LocalDate birthDate;
    @NotBlank
    private LoginDto login;
    @NotBlank
    private String nacionalNumber;
    @NotBlank
    private String descriminationColumn;

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
