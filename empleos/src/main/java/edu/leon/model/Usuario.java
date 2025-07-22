package edu.leon.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String nombre;
    private String email;
    private String password;
    private Integer estatus;
    private LocalDate fechaRegistro;
    //mucho a muchos
    //el orden de las llaves foraneas importa, primero va la clase actual
    @ManyToMany(fetch = FetchType.EAGER)//tambien inserta automaticamente los perfiles
    @JoinTable(name = "UsuarioPerfil",//tabla intermedia
            joinColumns = @JoinColumn(name = "idUsuario"),//tabla intermedia campo
            inverseJoinColumns = @JoinColumn(name = "idPerfil"))//tabla intermedia campo
    private List<Perfil> perfiles;

    public void agregar(Perfil perfil) {
        if (perfiles == null) {
            this.perfiles = new LinkedList<>();
        }
        this.perfiles.add(perfil);
    }

    public Integer getId() {
        return id;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario() {
    }

    public Usuario(Integer id, String username, String nombre, String email, String password, Integer estatus, LocalDate fechaRegistro, List<Perfil> perfiles) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;
        this.perfiles = perfiles;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", estatus=" + estatus +
                ", fechaRegistro=" + fechaRegistro +
                ", perfiles=" + perfiles +
                '}';
    }
}
