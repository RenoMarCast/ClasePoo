package TDA;

import Memoria.ArrayEstatico;
import Tools.TJOption;

public class Main {

    // Declaro el límite como constante (final) para que el 15 no se pueda modificar mientras corre el programa.
    private static final byte LIMITE = 15;

    // Punto de entrada del programa.
    public static void main(String[] args) {
        // Solo llamo al menú; así dejo el main limpio.
        menu();
    }

    public static void menu() {
        // Creo el arreglo estático de estudiantes con el límite fijo de 15.
        ArrayEstatico estudiantes = new ArrayEstatico(LIMITE);

        // Declaro la opción afuera del do-while porque el while necesita leerla para saber cuándo salir.
        String opcion;
        do {
            // Muestro la lista desplegable;
            opcion = TJOption.listaDesplegable(
                    "Pedir datos,Mostrar datos,Ordenar datos,Crear grupo,Asignar estudiante,Mostrar grupos,Salir");
            switch (opcion) {

                // Capturar: pido los datos de un estudiante y lo guardo en el array.
                case "Pedir datos":
                    estudiantes.addOjeto();
                    break;

                case "Mostrar datos":
                    if (estudiantes.empty()) {
                        TJOption.imprimeError("No hay estudiantes capturados");
                    } else {
                        // Los muestro en el orden de captura.
                        estudiantes.verObjetos();
                    }
                    break;

                // Ordenar: ordeno por promedio y muestro los datos ya ordenados.
                case "Ordenar datos":
                    // Misma validación: no tiene sentido ordenar si no hay datos.
                    if (estudiantes.empty()) {
                        TJOption.imprimeError("No hay estudiantes capturados.");
                    } else {
                        // Primero ordeno el arreglo de menor a mayor promedio.
                        estudiantes.ordenObjetos();
                        // Luego los muestro para que se vea el resultado ordenado.
                        estudiantes.verObjetos();
                    }
                    break;

                // Crear grupo: toda la lógica está en la clase Grupo.
                case "Crear grupo":
                    Grupo.crearGrupo();
                    break;

                // Asignar: necesito que existan estudiantes y grupos antes de relacionarlos.
                case "Asignar estudiante":
                    // Si no hay estudiantes no hay a quién asignar.
                    if (estudiantes.empty()) {
                        TJOption.imprimeError("Primero captura al menos un estudiante");
                        // Si no hay grupos no hay dónde asignar.
                    } else if (!Grupo.hayGrupos()) {
                        TJOption.imprimeError("Primero crea al menos un grupo");
                    } else {
                        // Le paso el arreglo de estudiantes a Grupo para que busque al estudiante ahí.
                        Grupo.asignarEstudiante(estudiantes);
                    }
                    break;

                // Mostrar grupos con sus estudiantes.
                case "Mostrar grupos":
                    // Valido que exista al menos un grupo.
                    if (!Grupo.hayGrupos()) {
                        TJOption.imprimeError("No hay grupos creados");
                    } else {
                        Grupo.mostrarGrupos();
                    }
                    break;

                // Salir: aviso que el programa termina.
                case "Salir":
                    TJOption.imprimirDatos("Programa finalizado");
                    break;
            }
            // Repito el menú mientras la opción no sea "Salir".
        } while (!opcion.equals("Salir"));
    }
}