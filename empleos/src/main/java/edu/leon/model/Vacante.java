package edu.leon.model;

import java.time.LocalDate;

public record Vacante(Integer id, String nombre, String descripcion, LocalDate fecha,Double salario,Integer destacado,String imagen) {
   public Vacante(){
       this(null,null,null,null,null,null,"no-image.png");
   }
   public Vacante(Integer id, String nombre, String descripcion, LocalDate fecha,Double salario,Integer destacado){
       this(id,nombre,descripcion,fecha,salario,destacado,"no-image.png");
   }
}
