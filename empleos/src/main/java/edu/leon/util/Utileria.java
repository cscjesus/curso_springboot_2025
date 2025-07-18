package edu.leon.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Utileria {
    public static String guardarArchivo(MultipartFile multiPart, String ruta){
        String nombreOriginal = multiPart.getOriginalFilename();
        try{
            File imageFile = new File(ruta + nombreOriginal);
            System.out.println("Archivo: " + imageFile.getAbsolutePath());
            multiPart.transferTo(imageFile);
            return nombreOriginal;
        }catch(IOException e){
            System.out.println("Error " +e.getMessage());
            return null;
        }
    }
}
