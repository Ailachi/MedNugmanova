package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Admin(){};
    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ADMIN INFO: " + this.email + " " + this.password;
    }
}
