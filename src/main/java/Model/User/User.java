package Model.User;

import Model.Announcement.Announcement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
    @OneToMany(mappedBy = "user")
    private List<Announcement> announcementList;


}
