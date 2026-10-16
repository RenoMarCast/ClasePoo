package TDA;

import Tools.TJOption;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Estacionamiento estacionamiento = null;   // null porque aun no se ha creado
        String opcion;
        do {
            opcion = TJOption.listaDesplegable(
                    "Crear estacionamiento,Agregar vehiculos al estacionamiento,Imprimir datos del estacionamiento,Salir");
            switch (opcion) {

                // a) Crea el estacionamiento
                case "Crear estacionamiento":
                    String nombreEst = TJOption.leerString("Nombre del estacionamiento");
                    estacionamiento = new Estacionamiento(nombreEst);
                    TJOption.imprimirDatos("Estacionamiento creado correctamente.");
                    break;

                // b) Captura estudiante y auto, y agrega el auto al estacionamiento
                case "Agregar vehiculos al estacionamiento":
                    if (estacionamiento == null) {
                        TJOption.imprimeError("Primero debes crear el estacionamiento");
                    } else if (estacionamiento.full()) {
                        TJOption.imprimeError("El estacionamiento ya esta lleno");
                    } else {
                        byte otro;
                        do {
                            // 1) Placa primero: si esta repetida, solo se vuelve a pedir la placa
                            String placa;
                            while (true) {
                                placa = TJOption.leerAlfanumerico("Placa del vehiculo");
                                if (estacionamiento.existePlaca(placa)) {
                                    TJOption.imprimeError("Ya existe un auto con esa placa");
                                } else {
                                    break;   // placa valida, sale del ciclo
                                }
                            }

                            // 2) El estudiante se crea por su cuenta
                            String numControl = TJOption.leerAlfanumerico("Numero de control del estudiante");
                            String nombreCompleto = TJOption.leerNombre("Nombre completo del estudiante");
                            Estudiante est = new Estudiante(numControl, nombreCompleto);

                            // 3) El auto se crea con la referencia a su estudiante
                            String marca = TJOption.leerString("Marca del vehiculo");
                            String modelo = TJOption.leerString("Modelo del vehiculo");
                            Auto auto = new Auto(placa, marca, modelo, est);

                            // 4) El estacionamiento agrega la referencia del auto
                            if (estacionamiento.agregarAuto(auto)) {
                                TJOption.imprimirDatos("Vehiculo agregado correctamente.");
                            }

                            // Si se lleno se detiene; si no, pregunta si agrega otro
                            if (estacionamiento.full()) {
                                TJOption.imprimirDatos("El estacionamiento llego al maximo de 10 vehiculos");
                                otro = 1;   // fuerza la salida del ciclo
                            } else {
                                otro = TJOption.siNo("Quieres agregar otro vehiculo?");
                            }
                        } while (otro == 0);   // 0 = boton "Si"
                    }
                    break;

                // c) Imprime los datos del estacionamiento
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
        } while (!opcion.equals("Salir"));
    }
}