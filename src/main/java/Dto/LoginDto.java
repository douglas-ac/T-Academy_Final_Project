package Dto;

import Dto.Slim.UserDtoSlim;
import Model.User.Login;
import Model.User.User;
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

}
