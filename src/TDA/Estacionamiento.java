package TDA;

import Memoria.ArrayEstatico;
import Tools.TJOption;

// Representa el estacionamiento. Guarda referencias a los autos que estan dentro
// usando el array estatico como memoria.
public class Estacionamiento {
    private String nombre;
    private ArrayEstatico autos;   // memoria donde se guardan los autos

    // Crea el estacionamiento con su nombre y un array de 10 espacios
    public Estacionamiento(String nombre) {
        this.nombre = nombre;
        autos = new ArrayEstatico((byte) 10);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Pregunta al array si ya esta lleno
    public boolean full() {
        return autos.full();
    }

    // Devuelve true si ya hay un auto con esa placa dentro del estacionamiento
    public boolean existePlaca(String placa) {
        return autos.busSecuencial(placa) != -2;
    }

    // Agrega un auto si hay espacio y la placa no esta repetida (respaldo de seguridad).
    // Devuelve true si lo agrego y false si no.
    public boolean agregarAuto(Auto a) {
        if (autos.full()) {
            TJOption.imprimeError("El estacionamiento esta lleno");
            return false;
        }
        if (existePlaca(a.getPlaca())) {
            TJOption.imprimeError("Ya existe un auto con esa placa");
            return false;
        }
        autos.addObjeto(a);
        return true;
    }

    // Arma el texto con los datos del estacionamiento y sus autos
    @Override
    public String toString() {
        String lista = "";
        if (autos.empty()) {
            lista = "(sin vehiculos)\n";
        } else {
            lista = autos.listado();
        }
        return "Estacionamiento: " + nombre + "\n"
                + "Vehiculos: " + autos.total() + "/10\n"
                + "-".repeat(40) + "\n" + lista;
    }
}