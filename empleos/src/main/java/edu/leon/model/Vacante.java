package edu.leon.model;

import java.time.LocalDateTime;

public record Vacante(Integer id, String nombre, String descripcion, LocalDateTime fecha,Double salario) {
   public Vacante(){
       this(null,null,null,null,null);
   }
}
