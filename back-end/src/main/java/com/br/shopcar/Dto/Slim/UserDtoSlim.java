package com.br.shopcar.Dto.Slim;

import com.br.shopcar.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDtoSlim {

    private long id;
    private String name;
    private String email;
    private String birthDate;
    private String nacionalNumber;
    private String fone;

    public User convertToModel(){
        User user = new User();
        user.setId(this.getId());
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        user.setBirthDate(this.getBirthDate());
        user.setNacionalNumber(this.getNacionalNumber());
        user.setFone(this.getFone());
        return user;
    }
}
