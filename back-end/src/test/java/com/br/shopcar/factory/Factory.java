package com.br.shopcar.factory;

import com.br.shopcar.Dto.GET.LoginDto;
import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Dto.POST.UserDtoPost;
import com.br.shopcar.Model.User.Login;
import com.br.shopcar.Model.User.User;

public class Factory {

    public static User createUser(){
        User user = new User();
        user.setId(1L);
        user.setName("Martim");
        Login login = new Login();
        login.setUsername("martim@gmail.com");
        login.setPassword("simba123");
        user.setLogin(login);

        return user;
    }

    public static UserDto createUserDTO(){
        User user = createUser();
        return user.converterDto();
    }

    public static UserDtoPost createUserDTOPost(){
        UserDtoPost userDtoPost = new UserDtoPost();
        userDtoPost.setName("Mario");
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("mario@gmail.com");
        loginDto.setPassword("senha123");
        userDtoPost.setLogin(loginDto);
        return userDtoPost;
    }
}
