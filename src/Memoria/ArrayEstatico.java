package Memoria;

import TDA.Estudiante;
import Tools.TJOption;

public class ArrayEstatico {
    private Estudiante datosEstudiante[];
    private byte pos;

    public ArrayEstatico(byte tam) {
        datosEstudiante = new Estudiante[tam];
        pos = -1;
    }

    // Metodo que valida si el array esta vacio
    public boolean empty() {
        return pos == -1;
    }

    public boolean full() {
        return pos == datosEstudiante.length - 1;
    }

    public Estudiante creaObjeto() {
        Estudiante est = new Estudiante();

        // Numero de control: obligatorio, alfanumerico y sin repetirse
        String numControl;
        while (true) {
            numControl = TJOption.leerAlfanumerico("Ingrese el numero de control: ");
            if (busSecuencial(numControl) == -2) {
                break;
            }
            TJOption.imprimeError("Ya existe un estudiante con ese número de control.");
        }
        est.setNumeroDeControl(numControl);

        est.setNombre(TJOption.leerNombre("Ingrese el nombre del estudiante: "));
        est.setCalificacion(TJOption.leerDoubleRango("Ingrese el promedio: ",
                Estudiante.CAL_MIN, Estudiante.CAL_MAX));
        return est;
    }

    public void addOjeto() {
        if (!full()) {
            // si hay espacio
            datosEstudiante[pos + 1] = creaObjeto();
            pos++;
        } else {
            TJOption.imprimeError("No hay espacio en el array");
        }
    }

    public void verObjetos() {
        StringBuilder unir = new StringBuilder();
        for (byte j = 0; j <= pos; j++) {
            unir.append("[").append(j).append("] ")
                    .append(datosEstudiante[j]).append("\n");
        }
        TJOption.imprimirDatos("Datos capturados \n" + unir);
    }

    // Ordena de menor a mayor promedio (burbuja)
    public void ordenObjetos() {
        Estudiante aux;
        for (byte i = 0; i < pos; i++) {
            for (byte j = 0; j < pos - i; j++) {
                if (datosEstudiante[j].getPromedio() > datosEstudiante[j + 1].getPromedio()) {
                    aux = datosEstudiante[j];
                    datosEstudiante[j] = datosEstudiante[j + 1];
                    datosEstudiante[j + 1] = aux;
                }
            }
        }
    }

    public Estudiante getEstudiante(byte posicion) {
        return datosEstudiante[posicion];
    }

    public byte busSecuencial(String numControl) {
        byte J;
        for (J = 0; J <= pos; J++) {
            if (numControl.equals(datosEstudiante[J].getNumeroDeControl())) {
                return J;
            }
        }
        return -2; // valor arbitrario
    }
}
