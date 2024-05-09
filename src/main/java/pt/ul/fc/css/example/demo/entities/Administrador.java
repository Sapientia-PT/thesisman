package pt.ul.fc.css.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Administrador {
    @Id
    private Long id;

    public Administrador(Long id) {
        this.id = id;
    }

    public Administrador() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
