package TDA;

import Tools.TJOption;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Grupo grupo = null;   // el grupo puede no existir todavía
        String opcion;
        do {
            opcion = TJOption.listaDesplegable("Crear grupo,Agregar alumno,Mostrar grupo,Salir");
            switch (opcion) {

                case "Crear grupo":
                    String clave = TJOption.leerAlfanumerico("Clave del grupo");
                    String curso = TJOption.leerString("Nombre del curso");
                    grupo = new Grupo(clave, curso);
                    TJOption.imprimirDatos("Grupo creado correctamente.");
                    break;

                case "Agregar alumno":
                    if (grupo == null) {
                        TJOption.imprimeError("Primero debes crear el grupo");
                    } else if (grupo.full()) {
                        TJOption.imprimeError("El grupo ya esta lleno");
                    } else {
                        byte otro;
                        do {
                            // El estudiante se crea por su cuenta...
                            String numControl = TJOption.leerAlfanumerico("Numero de control");
                            String nombre = TJOption.leerNombre("Nombre del alumno");
                            Estudiante est = new Estudiante(nombre, numControl);

                            // y luego se le pasa al grupo, que solo guarda la referencia
                            try {
                                grupo.agregarEstudiante(est);
                            } catch (IllegalArgumentException | IllegalStateException e) {
                                TJOption.imprimeError(e.getMessage());
                            }

                            if (grupo.full()) {
                                TJOption.imprimirDatos("El grupo llego al maximo de 15 alumnos");
                                otro = 1;   // fuerza la salida del ciclo
                            } else {
                                otro = TJOption.siNo("Quieres agregar otro alumno?");
                            }
                        } while (otro == 0);   // 0 = boton "Si"
                    }
                    break;

                case "Mostrar grupo":
                    if (grupo == null) {
                        TJOption.imprimeError("Primero debes crear el grupo");
                    } else {
                        TJOption.imprimir(grupo.toString());
                    }
                    break;

                case "Salir":
                    TJOption.imprimirDatos("Programa finalizado");
                    break;
            }
        } while (!opcion.equals("Salir"));
    }
}