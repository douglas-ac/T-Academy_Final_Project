package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Dto.POST.UserDtoPost;
import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDto> findAll(){
        List<User> allUser = userRepository.findAll();
        return allUser.stream().map(User::converterDto).collect(Collectors.toList());
    }

    public UserDto findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        User user = obj.orElseThrow(()-> new EntityNotFoundException("User not found"));
        return user.converterDto();
    }

    @Transactional
    public UserDto save(UserDtoPost userDtoPost){
        User user = userDtoPost.convertToModelPost();
        userRepository.save(user);
        return user.converterDto();
    }
    @Transactional
    public UserDto change(Long idUser, UserDto userDto){
        Optional<User> userToChange = userRepository.findById(idUser);
        User user = userToChange.orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setEmail(userDto.getEmail());
        user.setNacionalNumber(userDto.getNacionalNumber());
        user.setName(userDto.getName());
        user.setBirthDate(userDto.getBirthDate());
        user.setDescriminationColumn(userDto.getDescriminationColumn());
        User saved = userRepository.save(user);
        return saved.converterDto();
    }

    @Transactional
    public void delete(Long idUser){
        try {
            Optional<User> userToDelete = userRepository.findById(idUser);
            User user = userToDelete.orElseThrow(() -> new EntityNotFoundException("User not found"));
            userRepository.delete(user);
        } catch (Exception e){
            return; //exception handler
        }

    }

    public User findByIdModel(long id){
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(() -> new EntityNotFoundException("User not found"));
        return user;
    }
}
