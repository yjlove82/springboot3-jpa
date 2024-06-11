package git.yjlove82.springboot3jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "id", nullable = false, length = 20)
    private String id;

    @Column(name = "pass", nullable = false, length = 40)
    private String pass;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "phone", nullable = false, length = 32)
    private String phone;

    @Column(name = "email", nullable = false, length = 32)
    private String email;

    @Column(name = "date", nullable = false)
    private Instant date;

}