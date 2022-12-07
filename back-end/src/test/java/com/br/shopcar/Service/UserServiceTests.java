package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Dto.POST.UserDtoPost;
import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.UserRepository;
import com.br.shopcar.Factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    private Long existingId;
    private Long notExistingId;
    private User user;
    private UserDto userDto;

    private UserDtoPost userDtoPost;
    private List<User> users;

    @BeforeEach
    void setUp() throws Exception{
        existingId = 1L;
        notExistingId = 1000L;

        user = Factory.createUser();
        userDto = Factory.createUserDTO();
        userDtoPost = Factory.createUserDTOPost();

        users = new ArrayList<>(List.of(user));

        Mockito.doNothing().when(userRepository).delete(user);
        when(userRepository.findById(existingId)).thenReturn(Optional.of(user));
        when(userRepository.findAll()).thenReturn(users);
        when(userRepository.save(ArgumentMatchers.any())).thenReturn(user);
    }

    @Test
    void findAll_ShouldReturnListOfUserDTO(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 10) Pageable page){
       Page<UserDto> usersDTO = userService.findAll(page);

       Assertions.assertTrue(!usersDTO.isEmpty());
       verify(userRepository).findAll();
    }

    @Test
    void findById_ShouldReturnUserDTO_WhenIdExists(){
        UserDto userDTO = userService.findById(existingId);

        Assertions.assertEquals(userDTO.getId(), existingId);
        Assertions.assertNotNull(userDTO);

        verify(userRepository).findById(existingId);
    }

    @Test
    void findById_ShouldThrowEntityNotFoundException_WhenIdDoesNotExist(){

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            userService.findById(notExistingId);
        });

        verify(userRepository).findById(notExistingId);
    }

    @Test
    void save_ShouldReturnUserDTO(){
        UserDto userDto = userService.save(userDtoPost);

        Assertions.assertNotNull(userDto);
        verify(userRepository).save(any());
    }

    @Test
    void change_ShouldReturnUserDto_WhenIdExists(){
        userDto = userService.change(existingId, userDto);

        Assertions.assertNotNull(userDto);

        verify(userRepository).findById(existingId);
        verify(userRepository).save(user);
    }

    @Test
    void change_ShouldThrowEntityNotFoundException_WhenIdDoesNotExist(){

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            userDto = userService.change(notExistingId, userDto);
        });

        verify(userRepository).findById(notExistingId);
    }

    @Test
    void delete_ShouldDoNothing_WhenIdExists(){

        Assertions.assertDoesNotThrow(() -> {
            userService.delete(existingId);
        });

        verify(userRepository).delete(user);
    }

    @Test
    void delete_ShouldThrowEntityNotFoundException_WhenIdDoesNotExist(){
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            userService.findById(notExistingId);
        });

        verify(userRepository).findById(notExistingId);
    }

}
