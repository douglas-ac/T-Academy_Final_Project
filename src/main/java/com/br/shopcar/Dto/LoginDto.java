package com.br.shopcar.Dto;

import com.br.shopcar.Dto.Slim.UserDtoSlim;
import com.br.shopcar.Model.User.Login;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDto {

    private long id;
    private UserDtoSlim user;
    private String username;
    private String password;

    public Login convertToModel(){
        Login login = new Login();
        login.setId(this.getId());
        login.setUser(this.getUser().convertToModel());
        login.setUsername(this.getUsername());
        login.setPassword(this.getPassword());
        return login;
    }

}
