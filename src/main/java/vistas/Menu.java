// vistas/Menu.java
package vistas;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;


public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();

    @Override
    protected void exportarDatos() {
        archivoServicio.exportarPromedios(alumnoServicio.listarAlumnos());
        System.out.println("Datos exportados correctamente.");
    }

    @Override
    protected void crearAlumno() {
        System.out.print("Ingrese el RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la dirección del alumno: ");
        String direccion = scanner.nextLine();

        Alumno alumno = new Alumno("12345678-9", "Mapu");
        alumno.setRut(rut);
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDireccion(direccion);

        alumnoServicio.crearAlumno(alumno);
        System.out.println("Alumno creado correctamente.");
    }

    @Override
    protected void agregarMateria() {
        System.out.print("Ingrese el RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese la materia (MATEMATICAS, LENGUAJE, CIENCIA, HISTORIA): ");
        String materiaNombre = scanner.nextLine();

        Materia materia = new Materia("Matemáticas");
        materia.setNombre(MateriaEnum.valueOf(materiaNombre.toUpperCase()));

        alumnoServicio.agregarMateria(rut, materia);
        System.out.println("Materia agregada correctamente.");
    }

    @Override
    protected void agregarNotaPasoUno() {
        System.out.print("Ingrese el RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese la materia (MATEMATICAS, LENGUAJE, CIENCIA, HISTORIA): ");
        String materiaNombre = scanner.nextLine();
        System.out.print("Ingrese la nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        Materia materia = alumnoServicio.materiasPorAlumno(rut).stream()
                .filter(m -> m.getNombre().name().equalsIgnoreCase(materiaNombre))
                .findFirst()
                .orElse(null);

        if (materia != null) {
            materia.getNotas().add(nota);
            System.out.println("Nota agregada correctamente.");
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    @Override
    protected void listarAlumnos() {
        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("RUT: " + rut + ", Nombre: " + alumno.getNombre() + " " + alumno.getApellido());
        });
    }

    @Override
    protected void terminarPrograma() {
        System.out.println("Programa terminado.");
    }
}
