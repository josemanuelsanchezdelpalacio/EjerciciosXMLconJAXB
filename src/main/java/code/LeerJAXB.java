package code;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javaBeans.Instituto;
import static libs.FicheroEscribible.ficheroEscribible;

import java.nio.file.Path;

public class LeerJAXB {

    public static void leer(){
        Path p = Path.of("src/main/resources/insti.xml");

        if(ficheroEscribible(p)){
            Instituto insti;
            //un contexto se utiliza cuando en nuestro codigo hemos cargado algo persistente
            JAXBContext contexto = null;
            try {
                contexto = JAXBContext.newInstance(Instituto.class);
                Unmarshaller unmarshaller = contexto.createUnmarshaller();
                insti = (Instituto) unmarshaller.unmarshal(p.toFile());
                System.out.println(insti.getNombre());
                System.out.println(insti.getAlumnos());
            } catch (JAXBException e) {
                System.err.println("La clase no esta modificada correctamente para aplicar el contexto: " + e.getMessage());
            }
        }else{
            System.err.println("No existe o no se encuentra el fichero");
        }
    }
}
