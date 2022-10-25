package Model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Login {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private User user;
    private String username;
    private String password;

}
