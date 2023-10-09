package code;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javaBeans.Alumno;
import javaBeans.Instituto;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.ArrayList;

import static libs.FicheroEscribible.ficheroEscribible;

public class EscribirJAXB {

    public static void escribir(){
        Path p = Path.of("src/main/resources/insti2.xml");

        if(ficheroEscribible(p)){
            Instituto insti = new Instituto();
            insti.setNombre("Nombre del Instituto");

            ArrayList<Alumno> alumnos = new ArrayList<>();
            alumnos.add(new Alumno("DAM1", "Alumno1", 21));
            alumnos.add(new Alumno("DAM2","Alumno2", 22));
            insti.setAlumnos(alumnos);

            //un contexto se utiliza cuando en nuestro codigo hemos cargado algo persistente
            JAXBContext contexto = null;
            try {
                contexto = JAXBContext.newInstance(Instituto.class, Alumno.class);
                Marshaller marshaller = contexto.createMarshaller();
                marshaller.marshal(insti, System.out);
                marshaller.marshal(insti, p.toFile());
                marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);

            } catch (JAXBException e) {
                System.err.println("La clase no esta modificada correctamente para aplicar el contexto: " + e.getMessage());
            }
        }else{
            System.err.println("No existe o no se encuentra el fichero");
        }
    }

}
