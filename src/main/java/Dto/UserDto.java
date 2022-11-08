package Dto;

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
public class UserDto {

    private long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private LoginDto login;
    private List<AnnouncementDto> announcementList;
    private String nacionalNumber;
}
