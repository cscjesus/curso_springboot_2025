package edu.leon.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utileria {
    public static String guardarArchivo(MultipartFile multiPart, String ruta) {
        String nombreOriginal = multiPart.getOriginalFilename().replace(" ", "-");
        String nombreFinal = randomAlphaNumeric(8)+nombreOriginal;
        try {
            File imageFile = new File(ruta + nombreFinal);
            System.out.println("Archivo: " + imageFile.getAbsolutePath());
            multiPart.transferTo(imageFile);
            return nombreFinal;
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }

    /**
     * Metodo para generar una cadena aletoria de longitud N
     *
     * @param count
     * @return String
     */
    public static String randomAlphaNumeric(int count) {
        final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        return Stream.generate(() -> CHARS.charAt(random.nextInt(CHARS.length())))
                .limit(count)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
