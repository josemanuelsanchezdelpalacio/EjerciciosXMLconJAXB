import code.EscribirJAXB_JSON;
import code.LeerJAXB;
import code.LeerJSON;
import libs.Leer;

public class Main {
    public static void main(String[] args){
        boolean salir = false;
        int opcion;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Leer XML con JAXB");
            System.out.println("2. Escribir XML con JAXB y JSON");
            System.out.println("3. Leer JSON con GSON");

            opcion = Leer.pedirEntero("Introduce una opción: ");

            switch (opcion) {
                case 0 -> {salir = true;}
                case 1 -> {LeerJAXB.leer();}
                case 2 -> {EscribirJAXB_JSON.escribir();}
                case 3 -> {LeerJSON.leer();}
                default -> {System.out.println("La opcion seleccionada no existe");}
            }
        } while (!salir);
    }
}
