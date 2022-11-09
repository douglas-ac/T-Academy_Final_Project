package com.br.shopcar.Model.User;

import com.br.shopcar.Dto.LoginDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Login {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    private String username;
    private String password;

    public LoginDto converter(){
        LoginDto loginDto = new LoginDto();
        loginDto.setId(this.getId());
        loginDto.setUser(this.user.converterDtoSlim());
        loginDto.setUsername(this.getUsername());
        loginDto.setPassword(this.getPassword());
        return loginDto;
    }
}
