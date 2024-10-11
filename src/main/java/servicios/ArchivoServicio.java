// servicios/ArchivoServicio.java
package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ArchivoServicio {
    public void exportarPromedios(Map<String, Alumno> listaAlumnos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("promedios.txt"))) {
            for (Alumno alumno : listaAlumnos.values()) {
                writer.write("Alumno : " + alumno.getRut() + " - " + alumno.getNombre() + "\n");
                for (Materia materia : alumno.getMaterias()) {
                    double promedio = materia.getNotas().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    writer.write("Materia : " + materia.getNombre() + " - Promedio : " + promedio + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
