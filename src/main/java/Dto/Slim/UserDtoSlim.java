package Dto.Slim;

import Dto.AnnouncementDto;
import Dto.LoginDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDtoSlim {

    private long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String nacionalNumber;
}
