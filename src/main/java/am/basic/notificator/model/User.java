package am.basic.notificator.model;

import am.basic.notificator.model.lcp.UserStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private String code;

    @NotBlank(message = "Username must not be blank")
    @Column(name = "username", nullable = false, unique = true)
    private String username;


    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must be more then 6 characters")
    private String password;

    @Enumerated
    @Column(name = "status", nullable = false)
    private UserStatus status;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;


}
