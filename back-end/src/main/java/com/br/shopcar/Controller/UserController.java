package com.br.shopcar.Controller;

import com.br.shopcar.Dto.POST.UserDtoPost;
import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserDto> findById(@PathVariable("idUser") long idUser){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(idUser));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDtoPost userDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDtoPost));
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<UserDto> change(@PathVariable("idUser") long idUser,
                                           @RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.change(idUser, userDto));
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Void> excluir(@PathVariable("idUser") long idUser){
        userService.delete(idUser);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
