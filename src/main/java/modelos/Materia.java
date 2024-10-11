// modelos/Materia.java
package modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas;

    public Materia(String matemáticas) {
        this.notas = new ArrayList<>(); // Inicializar la lista de notas
    }

    // Getters y Setters
    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}

