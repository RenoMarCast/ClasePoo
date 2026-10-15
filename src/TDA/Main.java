package TDA;

import Tools.TJOption;

// Clase principal: muestra el menu y conecta al usuario con las demas clases
public class Main {

    // Punto de entrada del programa; solo llama al menu
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Estacionamiento estacionamiento = null;   // empieza en null porque aun no se ha creado
        String opcion;
        do {
            // Muestra la lista desplegable con las opciones del menu
            opcion = TJOption.listaDesplegable(
                    "Crear estacionamiento,Agregar vehiculos al estacionamiento,Imprimir datos del estacionamiento,Salir");
            switch (opcion) {

                // a) Crea el estacionamiento con el nombre que escriba el usuario
                case "Crear estacionamiento":
                    String nombreEst = TJOption.leerString("Nombre del estacionamiento");
                    estacionamiento = new Estacionamiento(nombreEst);
                    TJOption.imprimirDatos("Estacionamiento creado correctamente.");
                    break;

                // b) Captura estudiante y vehiculo, y mete el vehiculo al estacionamiento
                case "Agregar vehiculos al estacionamiento":
                    if (estacionamiento == null) {
                        // Validacion: no se puede agregar si no existe el estacionamiento
                        TJOption.imprimeError("Primero debes crear el estacionamiento");
                    } else if (estacionamiento.full()) {
                        TJOption.imprimeError("El estacionamiento ya esta lleno");
                    } else {
                        byte otro;
                        do {
                            // 1) El estudiante se crea por su cuenta, antes que el vehiculo
                            String numControl = TJOption.leerAlfanumerico("Numero de control del estudiante");
                            String nombreCompleto = TJOption.leerNombre("Nombre completo del estudiante");
                            Estudiante est = new Estudiante(numControl, nombreCompleto);

                            // 2) El vehiculo se crea y guarda la referencia a su estudiante
                            String placa = TJOption.leerAlfanumerico("Placa del vehiculo");
                            String marca = TJOption.leerString("Marca del vehiculo");
                            String modelo = TJOption.leerString("Modelo del vehiculo");
                            Vehiculo v = new Vehiculo(placa, marca, modelo, est);

                            // 3) El estacionamiento solo agrega la referencia del vehiculo.
                            // try-catch atrapa los errores (lleno o placa repetida) y los muestra
                            try {
                                estacionamiento.agregarVehiculo(v);
                                TJOption.imprimirDatos("Vehiculo agregado correctamente.");
                            } catch (IllegalArgumentException | IllegalStateException e) {
                                TJOption.imprimeError(e.getMessage());
                            }

                            // Si se llego a 10 vehiculos se detiene; si no, pregunta si agrega otro
                            if (estacionamiento.full()) {
                                TJOption.imprimirDatos("El estacionamiento llego al maximo de 10 vehiculos");
                                otro = 1;   // fuerza la salida del ciclo
                            } else {
                                otro = TJOption.siNo("Quieres agregar otro vehiculo?");
                            }
                        } while (otro == 0);   // 0 = boton "Si"
                    }
                    break;

                // c) Muestra el nombre, cuantos vehiculos hay y la lista completa
                case "Imprimir datos del estacionamiento":
                    if (estacionamiento == null) {
                        TJOption.imprimeError("Primero debes crear el estacionamiento");
                    } else {
                        TJOption.imprimir(estacionamiento.toString());
                    }
                    break;

                // d) Termina el programa
                case "Salir":
                    TJOption.imprimirDatos("Programa finalizado");
                    break;
            }
        } while (!opcion.equals("Salir"));   // el menu se repite hasta elegir Salir
    }
}