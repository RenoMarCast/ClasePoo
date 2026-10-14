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

    public boolean empty() {
        return pos == -1;
    }

    public boolean full() {
        return pos == datosEstudiante.length - 1;
    }

    public byte total() {
        return (byte) (pos + 1);
    }

    // Recibe un estudiante que ya existe y guarda su referencia
    public void addObjeto(Estudiante est) {
        if (!full()) {
            datosEstudiante[pos + 1] = est;
            pos++;
        } else {
            TJOption.imprimeError("No hay espacio en el array");
        }
    }

    // Arma el texto con los estudiantes guardados
    public String listado() {
        StringBuilder unir = new StringBuilder();
        for (byte j = 0; j <= pos; j++) {
            unir.append("[").append(j).append("] ")
                    .append(datosEstudiante[j]).append("\n");
        }
        return unir.toString();
    }

    public void verObjetos() {
        TJOption.imprimirDatos("Datos capturados \n" + listado());
    }

    /* Comentado porque ya no se usa (el estudiante se crea fuera del array
       y ya no tiene promedio):
    public Estudiante creaObjeto() { ... }
    public void ordenObjetos() { ... }
    */

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