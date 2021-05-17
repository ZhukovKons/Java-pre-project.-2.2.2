package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 15, message = "Имя не может быть менее 2 символов или более 15")
    private String name;

    @Column(name = "lastname")
    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 15, message = "Фамилия не может быть менее 2 символов или более 15")
    private String lastname;

    @Column(name = "email")
    @Email(message = "Не верный формат Email")
    private String email;

    /** Old User Start **/

    public User() {
    }

    public User(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User: " +
                "id= " + id +
                ", name= " + name +
                ", lastname= " + lastname +
                ", email= " + email;
    }

    /** Old User END **/
}