package edu.leon.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Solicitudes")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private String comentarios;
    private String archivo;
    //relaciones
    @OneToOne
    @JoinColumn(name = "idVacante") // idVacante clave foranea
    private Vacante vacante;

    @OneToOne
    @JoinColumn(name = "idUsuario") // idUsuario clave foranea
    private Usuario usuario ;

    public String fechaFormat() {
        return fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString();
    }

    public Solicitud() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", comentarios='" + comentarios + '\'' +
                ", archivo='" + archivo + '\'' +
                ", vacante=" + vacante +
                ", usuario=" + usuario +
                '}';
    }
}
