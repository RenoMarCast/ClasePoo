package Memoria;

import TDA.Estudiante;
import Tools.TJOption;

import java.util.ArrayList;

public class ArrayDinamico {
    public ArrayList<Estudiante> dato;

    public ArrayDinamico(byte tamaño) {
        dato = new ArrayList<Estudiante>();
    }

    public boolean isEmpy() {
        return dato.isEmpty();
    }

    public Estudiante creaObjeto() {
        Estudiante est = new Estudiante();

        // Numero de control: obligatorio, alfanumerico y sin repetirse
        String numControl;
        while (true) {
            numControl = TJOption.leerAlfanumerico("Numero de control");
            if (busSecuencial(numControl) == -2) {
                break;
            }
            TJOption.imprimeError("Ya existe un estudiante con ese número de control.");
        }
        est.setNumeroDeControl(numControl);

        est.setNombre(TJOption.leerNombre("Nombre"));
        est.setCalificacion(TJOption.leerDoubleRango("Promedio",
                Estudiante.CAL_MIN, Estudiante.CAL_MAX));
        return est;
    }

    public void addObjeto() {
        dato.add(creaObjeto());
    }

    public void ordenaObjetoBurbuja() {
        byte i, j;
        Estudiante aux;
        for (i = 0; i < dato.size(); i++)
            for (j = (byte) (i + 1); j < dato.size(); j++) {
                if (dato.get(i).getPromedio() > dato.get(j).getPromedio()) {
                    aux = dato.get(i);
                    dato.set(i, dato.get(j));
                    dato.set(j, aux);
                }
            }
    }

    public void verObjeto() {
        byte J;
        String unir = "";
        for (J = 0; J < dato.size(); J++) {
            unir += "[" + J + "] " + dato.get(J).toString() + "\n";
        }
        TJOption.imprimir("Datos capturados\n" + unir);
    }

    public Estudiante getEstudiante(byte posicion) {
        return dato.get(posicion);
    }

    public byte busSecuencial(String numControl) {
        byte J;
        for (J = 0; J < dato.size(); J++) {
            if (numControl.equals(dato.get(J).getNumeroDeControl())) {
                return J;
            }
        }
        return -2;
    }
}