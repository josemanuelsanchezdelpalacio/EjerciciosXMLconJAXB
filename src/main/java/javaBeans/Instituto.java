package javaBeans;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;

@XmlRootElement(name = "instituto")
@XmlType(propOrder = {"nombre", "alumnos"})
public class Instituto {

    private String nombre;
    private ArrayList<Alumno> alumnos;

    public Instituto() {}

    //para etiquetas simples
    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //para etiquetas que contengan otras etiquetas
    @XmlElementWrapper(name = "alumnos")
    @XmlElement(name = "alumno")
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", alumnos=" + alumnos +
                '}';
    }
}
