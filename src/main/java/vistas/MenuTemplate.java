// vistas/MenuTemplate.java
package vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    public void iniciarMenu() {
        int opcion;
        do {
            System.out.println("1. Crear Alumno");
            System.out.println("2. Agregar Materia");
            System.out.println("3. Agregar Nota");
            System.out.println("4. Listar Alumnos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Terminar Programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    agregarMateria();
                    break;
                case 3:
                    agregarNotaPasoUno();
                    break;
                case 4:
                    listarAlumnos();
                    break;
                case 5:
                    exportarDatos();
                    break;
                case 6:
                    terminarPrograma();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    protected abstract void exportarDatos();
    protected abstract void crearAlumno();
    protected abstract void agregarMateria();
    protected abstract void agregarNotaPasoUno();
    protected abstract void listarAlumnos();
    protected abstract void terminarPrograma();
}

