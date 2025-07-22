package edu.leon.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Perfiles")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String perfil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Perfil() {
    }

    public Perfil(Integer id, String perfil) {
        this.id = id;
        this.perfil = perfil;
    }
    public Perfil(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
