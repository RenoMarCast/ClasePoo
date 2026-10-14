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
        // Numero de control: obligatorio, alfanumerico y sin repetirse
        String numControl;
        while (true) {
            numControl = TJOption.leerAlfanumerico("Numero de control");
            if (busSecuencial(numControl) == -2) {
                break;
            }
            TJOption.imprimeError("Ya existe un estudiante con ese número de control.");
        }

        String nombre = TJOption.leerNombre("Nombre");
        return new Estudiante(nombre, numControl);
    }

    public void addObjeto() {
        dato.add(creaObjeto());
    }

    // Ordena alfabeticamente por nombre (burbuja); antes era por promedio
    public void ordenaObjetoBurbuja() {
        byte i, j;
        Estudiante aux;
        for (i = 0; i < dato.size(); i++)
            for (j = (byte) (i + 1); j < dato.size(); j++) {
                if (dato.get(i).getNombre().compareToIgnoreCase(dato.get(j).getNombre()) > 0) {
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