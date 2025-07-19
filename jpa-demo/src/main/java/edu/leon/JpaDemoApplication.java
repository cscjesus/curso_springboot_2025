package edu.leon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		System.out.println("Ejemplos de Spring Data JPA");
        guardar();
    }

    private void guardar() {
        System.out.println("Insertando ...");
    }
//seccion 8 video 9
}
