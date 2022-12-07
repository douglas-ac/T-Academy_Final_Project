package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.Slim.UserDtoSlim;
import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Dto.POST.UserDtoPost;
import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.PasswordTokenRepository;
import com.br.shopcar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    PasswordTokenRepository passwordTokenRepository;

    public Page<UserDto> findAll(Pageable pageable){
        return userRepository.findAll(pageable).map(User::converterDto);
    }

    public UserDto findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        User user = obj.orElseThrow(()-> new EntityNotFoundException("User not found"));
        return user.converterDto();
    }

    @Transactional
    public UserDtoSlim save(UserDtoPost userDtoPost){
        User user = userDtoPost.convertToModelPost();
        user.getLogin().setPassword(passwordEncoder.encode(user.getLogin().getPassword()));
        userRepository.save(user);
        return user.converterDtoSlim();
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byLoginUsername = userRepository.findByLoginUsername(username);
        return byLoginUsername.getLogin();
    }

    public UserDtoSlim changePassword(long idUser, String oldPassword, String password) {
        System.out.println(oldPassword);
        System.out.println(password);
        Optional<User> byId = userRepository.findById(idUser);
        User user = byId.orElseThrow(() -> new EntityNotFoundException("User not found"));
        if (passwordEncoder.matches(oldPassword, user.getLogin().getPassword())){
            System.out.println("true");
            user.getLogin().setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            return user.converterDtoSlim();
        }
        else {
            throw new IllegalArgumentException("Old password wrong");
        }
    }
 }
