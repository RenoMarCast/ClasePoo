package Memoria;

import TDA.Auto;
import Tools.TJOption;

public class ArrayEstatico {
    private Auto datosAuto[];   // guarda las referencias a los autos
    private byte pos;           // posicion del ultimo auto guardado (-1 = vacio)

    // Crea el arreglo con el tamano indicado y lo deja vacio
    public ArrayEstatico(byte tam) {
        datosAuto = new Auto[tam];
        pos = -1;
    }

    // Indica si no hay ningun auto guardado
    public boolean empty() {
        return pos == -1;
    }

    // Indica si ya no caben mas autos
    public boolean full() {
        return pos == datosAuto.length - 1;
    }

    // Devuelve cuantos autos hay guardados
    public byte total() {
        return (byte) (pos + 1);
    }

    // Guarda la referencia de un auto ya creado, si todavia hay espacio
    public void addObjeto(Auto a) {
        if (!full()) {
            datosAuto[pos + 1] = a;
            pos++;
        } else {
            TJOption.imprimeError("No hay espacio en el array");
        }
    }

    // Arma el texto con los autos guardados, uno por linea
    public String listado() {
        StringBuilder unir = new StringBuilder();
        for (byte j = 0; j <= pos; j++) {
            unir.append("[").append(j).append("] ")
                    .append(datosAuto[j]).append("\n");
        }
        return unir.toString();
    }

    // Devuelve el auto de la posicion indicada
    public Auto getAuto(byte posicion) {
        return datosAuto[posicion];
    }

    // Busqueda secuencial por placa: devuelve la posicion o -2 si no existe.
    // equalsIgnoreCase compara sin importar mayusculas o minusculas (abc123 = ABC123)
    public byte busSecuencial(String placa) {
        byte j;
        for (j = 0; j <= pos; j++) {
            if (placa.equalsIgnoreCase(datosAuto[j].getPlaca())) {
                return j;
            }
        }
        return -2;
    }
}