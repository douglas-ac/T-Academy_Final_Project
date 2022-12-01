package com.br.shopcar.Dto.GET;

import com.br.shopcar.Model.User.Login;
import com.br.shopcar.Model.User.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public Login convertToModel(){
        Login login = new Login();
        login.setUsername(this.getUsername());
        login.setPassword(this.getPassword());
        login.setRoles(this.getRoles());
        return login;
    }

}
