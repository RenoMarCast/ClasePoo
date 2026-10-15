package TDA;

import Memoria.ArrayEstatico;

// Representa el estacionamiento. Agrega temporalmente referencias a los vehiculos
// que estan dentro (agregacion), usando el array estatico como memoria.
public class Estacionamiento {
    // Capacidad maxima que pide el ejercicio; constante para no repetir el numero 10
    public static final byte CAPACIDAD = 10;

    private String nombre;
    private ArrayEstatico vehiculos;   // memoria donde se guardan los vehiculos

    // Crea el estacionamiento con su nombre y su array del tamano de la capacidad
    public Estacionamiento(String nombre) {
        setNombre(nombre);
        vehiculos = new ArrayEstatico(CAPACIDAD);
    }

    // Guarda el nombre validando que no venga vacio
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre del estacionamiento no puede estar vacío.");
        this.nombre = nombre.trim();
    }

    public String getNombre() { return nombre; }

    // Pregunta al array si ya se alcanzo la capacidad maxima
    public boolean full() { return vehiculos.full(); }

    // Devuelve cuantos vehiculos hay dentro
    public byte total() { return vehiculos.total(); }

    // Agrega un vehiculo al estacionamiento, validando antes:
    // que exista, que haya espacio y que su placa no este repetida
    public void agregarVehiculo(Vehiculo v) {
        if (v == null)
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        if (vehiculos.full())
            throw new IllegalStateException("El estacionamiento está lleno (máximo " + CAPACIDAD + ").");
        if (vehiculos.busSecuencial(v.getPlaca()) != -2)
            throw new IllegalArgumentException("Ya existe un vehículo con la placa " + v.getPlaca());
        vehiculos.addObjeto(v);
    }

    // Arma el texto con los datos del estacionamiento y sus vehiculos para imprimirlo
    @Override
    public String toString() {
        String lista = vehiculos.empty() ? "(sin vehículos)\n" : vehiculos.listado();
        return "Estacionamiento: " + nombre + "\n"
                + "Vehículos: " + vehiculos.total() + "/" + CAPACIDAD + "\n"
                + "-".repeat(40) + "\n" + lista;
    }
}
