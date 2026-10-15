package Memoria;

import TDA.Vehiculo;
import Tools.TJOption;

// Tipo de memoria estatica: un arreglo de tamano fijo para guardar vehiculos.
// Se usa porque el ejercicio dice que el limite es de 10 vehiculos.
public class ArrayEstatico {
    private Vehiculo datosVehiculo[];   // arreglo que guarda las referencias a los vehiculos
    private byte pos;                   // posicion del ultimo vehiculo guardado (-1 = vacio)

    // Crea el arreglo con el tamano indicado y lo deja vacio
    public ArrayEstatico(byte tam) {
        datosVehiculo = new Vehiculo[tam];
        pos = -1;
    }

    // Indica si no hay ningun vehiculo guardado
    public boolean empty() {
        return pos == -1;
    }

    // Indica si ya no caben mas vehiculos
    public boolean full() {
        return pos == datosVehiculo.length - 1;
    }

    // Devuelve cuantos vehiculos hay guardados
    public byte total() {
        return (byte) (pos + 1);
    }

    // Guarda la referencia de un vehiculo ya creado, si todavia hay espacio
    public void addObjeto(Vehiculo v) {
        if (!full()) {
            datosVehiculo[pos + 1] = v;
            pos++;
        } else {
            TJOption.imprimeError("No hay espacio en el array");
        }
    }

    // Arma un texto con todos los vehiculos guardados, uno por linea y numerados
    public String listado() {
        StringBuilder unir = new StringBuilder();
        for (byte j = 0; j <= pos; j++) {
            unir.append("[").append(j + 1).append("] ")
                    .append(datosVehiculo[j]).append("\n");
        }
        return unir.toString();
    }

    // Devuelve el vehiculo que esta en la posicion indicada
    public Vehiculo getVehiculo(byte posicion) {
        return datosVehiculo[posicion];
    }

    // Busqueda secuencial: recorre el arreglo buscando una placa.
    // Devuelve la posicion si la encuentra, o -2 si no existe.
    public byte busSecuencial(String placa) {
        for (byte j = 0; j <= pos; j++) {
            if (placa.equalsIgnoreCase(datosVehiculo[j].getPlaca())) {
                return j;
            }
        }
        return -2;
    }
}