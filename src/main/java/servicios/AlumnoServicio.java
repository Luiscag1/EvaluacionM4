// servicios/AlumnoServicio.java
package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos = new HashMap<>();

    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    public void agregarMateria(String rutAlumno, Materia materia) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            if (alumno.getMaterias() == null) {
                alumno.setMaterias(new ArrayList<>()); // Inicializar la lista si es null
            }
            alumno.getMaterias().add(materia);
        }
    }

    public List<Materia> materiasPorAlumno(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        return alumno != null ? alumno.getMaterias() : null;
    }

    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}
