package edu.leon;

import edu.leon.respositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
    @Autowired
    private CategoriasRepository categoriasRepo;
    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(categoriasRepo);
    }

    private void guardar() {
        System.out.println("Insertando ...");
    }
    private void eliminar() {
        System.out.println("Elimando ...");
    }
//seccion 8 video 12
}
