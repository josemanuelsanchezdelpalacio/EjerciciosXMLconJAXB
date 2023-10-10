package code;


import com.google.gson.Gson;
import javaBeans.Alumno;
import javaBeans.Instituto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class LeerJSON {

    public static void leer() {
        Path p = Path.of("src/main/resources/instiGson.json");

        Instituto intiJson;
        //leemos el contenido del JSON, que es un texto

        String txtJson;

        try {
            txtJson = Files.readString(p);

            //creo el Gson que transforma de texto a objetos
            Gson gson = new Gson();
            intiJson = gson.fromJson(txtJson, Instituto.class);
            System.out.println(intiJson.getNombre());
            for (Alumno a : intiJson.getAlumnos()) {
                System.out.println(a.getNombre());
            }
        } catch (FileNotFoundException | NoSuchFileException e) {
            System.err.println("El archivo no existe" + e.getMessage());
        } catch (MalformedInputException e) {
            System.err.println("Comprueba que la codificación del archivo sea UTF-8" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}

