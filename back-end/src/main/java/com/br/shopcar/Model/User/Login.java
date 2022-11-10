package com.br.shopcar.Model.User;

import com.br.shopcar.Dto.GET.LoginDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Login {

    private String username;
    private String password;

    public LoginDto converter(){
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(this.getUsername());
        loginDto.setPassword(this.getPassword());
        return loginDto;
    }
}
