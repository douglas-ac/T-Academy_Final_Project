package com.br.shopcar.Controller;

import com.br.shopcar.Dto.ChangePassordDTO;
import com.br.shopcar.Dto.GET.Slim.UserDtoSlim;
import com.br.shopcar.Dto.POST.UserDtoPost;
import com.br.shopcar.Dto.GET.UserDto;
import com.br.shopcar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 10) Pageable page){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(page));
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserDto> findById(@PathVariable("idUser") long idUser){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(idUser));
    }

    @PostMapping
    public ResponseEntity<UserDtoSlim> save(@Valid @RequestBody UserDtoPost userDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDtoPost));
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<UserDto> change(@PathVariable("idUser") long idUser,
                                           @RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.change(idUser, userDto));
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Void> delete(@PathVariable("idUser") long idUser){
        userService.delete(idUser);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/changePassword/{idUser}")
    public ResponseEntity changePassword(@PathVariable("idUser") long idUser,
                                                  @RequestBody ChangePassordDTO content){
        return ResponseEntity.status(HttpStatus.OK).body(userService.changePassword(idUser, content.getOldPassord(), content.getNewPassord()));
    }
}
