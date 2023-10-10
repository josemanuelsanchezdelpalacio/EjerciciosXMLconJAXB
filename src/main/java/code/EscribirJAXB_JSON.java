package code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import javaBeans.Alumno;
import javaBeans.Instituto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static libs.FicheroEscribible.ficheroEscribible;

public class EscribirJAXB_JSON {

    public static void escribir() {
        Path p = Path.of("target/insti2.xml");
        Path pJson = Path.of("target/instiGson.json");

        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        Instituto insti = new Instituto();
        insti.setNombre("IES San Alberto Magno");

        Alumno a1 = new Alumno("SMR1", "Lola", 16);
        Alumno a2 = new Alumno("DAM1", "Lola", 20);
        Alumno a3 = new Alumno("DAM2", "Sofía", 21);

        listaAlumnos.add(a1);
        listaAlumnos.add(a2);
        listaAlumnos.add(a3);
        insti.setAlumnos(listaAlumnos);


        //un contexto se utiliza cuando en nuestro codigo hemos cargado algo persistente
        JAXBContext contexto = null;
        try {
            contexto = JAXBContext.newInstance(Instituto.class, Alumno.class);
            //para pasar de codigo a XML
            Marshaller marshaller = contexto.createMarshaller();
            /*System.out.print("XML -> ");
            marshaller.marshal(insti, System.out);*/
            //escribimos el archivo con setProperty para formatearlo
            if (ficheroEscribible(p)) {
                marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(insti, p.toFile());
            } else {
                System.err.println("No existe o no se encuentra el fichero");
            }

            //con la API Gson creamos el JSON
            GsonBuilder gsonBuilder = new GsonBuilder();
            //escribimos el JSON con setPretty para formatearlo
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            //creo el texto del json
            String jsonInsti = gson.toJson(insti);
            if(ficheroEscribible(p)){
                Files.writeString(pJson, jsonInsti);
            }

        } catch (JAXBException e) {
            System.err.println("La clase no esta modificada correctamente para aplicar el contexto: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }

    }
}