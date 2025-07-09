package edu.leon.model;

import java.time.LocalDate;

public record Vacante(Integer id, String nombre, String descripcion, LocalDate fecha,Double salario,Integer destacado) {
   public Vacante(){
       this(null,null,null,null,null,null);
   }
}
