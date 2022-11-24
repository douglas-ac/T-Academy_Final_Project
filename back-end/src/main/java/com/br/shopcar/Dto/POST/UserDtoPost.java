package com.br.shopcar.Dto.POST;

import com.br.shopcar.Dto.GET.LoginDto;
import com.br.shopcar.Model.Announcement.Adress;
import com.br.shopcar.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDtoPost {

    private long id;
    @NotBlank
    private String name;
    @NotBlank @Email(message = "Email inválido")
    private String email;
    @NotBlank @Pattern(message = "Data deve estar no formato dd-mm-aaaa", regexp = "^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$")
    private String birthDate;
    @NotNull
    private LoginDto login;
    @NotBlank
    private String nacionalNumber;
    @NotBlank
    private String descriminationColumn;
    @NotBlank @Pattern(message = "Telefone inválido", regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")
    private String fone;
    private Adress adress;

    public User convertToModelPost(){
        User user = new User();
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setBirthDate(this.getBirthDate());
        user.setLogin(this.getLogin().convertToModel());
        user.setNacionalNumber(this.getNacionalNumber());
        user.setDescriminationColumn(this.getDescriminationColumn());
        user.setFone(this.getFone());
        return user;
    }
}
