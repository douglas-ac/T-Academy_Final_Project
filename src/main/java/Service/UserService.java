package Service;

import Dto.UserDto;
import Mapper.Mapper;
import Model.User.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.*;

public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Mapper mapper;

    public List<UserDto> findAll(){
        List<User> allUser = userRepository.findAll();
        List<UserDto> allUserDtos = new ArrayList<>();
        allUser.forEach( user -> allUserDtos.add(mapper.userToDto(user)));
        return allUserDtos;
    }

    public UserDto findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        User user = obj.orElseThrow(()-> new EntityNotFoundException("User not found"));
        return mapper.userToDto(user);
    }

    @Transactional
    public UserDto save(UserDto userDto){
        User user = mapper.userDtoToModel(userDto);
        return mapper.userToDto(userRepository.save(user));
    }

    public UserDto change(Long idUser, User userDto){
        Optional<User> userToChange = userRepository.findById(idUser);
        User user = userToChange.orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setEmail(userDto.getEmail());
        user.setNacionalNumber(userDto.getNacionalNumber());
        user.setName(userDto.getName());
        user.setBirthDate(userDto.getBirthDate());

        return this.save(mapper.userToDto(user));
    }

    @Transactional
    public void excluir(Long idUser){
        try {
            Optional<User> userToDelete = userRepository.findById(idUser);
            User user = userToDelete.orElseThrow(() -> new EntityNotFoundException("User not found"));
            userRepository.delete(user);
        } catch (Exception e){
            return; //exception handler
        }

    }
}
