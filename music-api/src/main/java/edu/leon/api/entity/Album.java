package edu.leon.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "Albums")
public class Album {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private LocalDate lanzado;
    private String genero;
    private Double precio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getLanzado() {
        return lanzado;
    }

    public void setLanzado(LocalDate lanzado) {
        this.lanzado = lanzado;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + titulo + '\'' +
                ", lanzado=" + lanzado +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }
}
