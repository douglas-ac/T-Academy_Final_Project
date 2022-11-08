package Mapper;

import Dto.AnnouncementDto;
import Dto.LoginDto;
import Dto.UserDto;
import Model.Announcement.Announcement;
import Model.User.Login;
import Model.User.User;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    UserDto userToDto(User user);
    User userDtoToModel(UserDto userDto);

    LoginDto loginToDto(Login login);
    Login loginDtoToModel(LoginDto loginDto);

    AnnouncementDto announcementToDto(Announcement announcement);
    Announcement announcementDtoToModel(AnnouncementDto announcementDto);

}
