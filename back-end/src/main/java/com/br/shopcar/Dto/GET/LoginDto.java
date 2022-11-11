package com.br.shopcar.Dto.GET;

import com.br.shopcar.Model.User.Login;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDto {

    private String username;
    private String password;

    public Login convertToModel(){
        Login login = new Login();
        login.setUsername(this.getUsername());
        login.setPassword(this.getPassword());
        return login;
    }

}
