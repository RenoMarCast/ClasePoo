package TDA;

// Representa a un estudiante. Existe por su cuenta, no depende del vehiculo ni del estacionamiento.
public class Estudiante {
    // Identifican al estudiante (los pide el diagrama)
    private String numeroControl;
    private String nombreCompleto;

    // Constructor: recibe los datos al crear el estudiante y los guarda usando los setters
    public Estudiante(String numeroControl, String nombreCompleto) {
        setNumeroControl(numeroControl);
        setNombreCompleto(nombreCompleto);
    }

    // Guarda el numero de control, validando que no venga vacio
    public void setNumeroControl(String numeroControl) {
        if (numeroControl == null || numeroControl.isBlank()) {
            throw new IllegalArgumentException("El número de control no puede estar vacío.");
        }
        this.numeroControl = numeroControl.trim();   // trim quita espacios sobrantes
    }

    // Guarda el nombre completo, validando que no venga vacio
    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.isBlank()) {
            throw new IllegalArgumentException("El nombre completo no puede estar vacío.");
        }
        this.nombreCompleto = nombreCompleto.trim();
    }

    // Getters: permiten leer los atributos privados desde otras clases
    public String getNumeroControl() {
        return numeroControl;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    // Convierte el objeto a texto para poder imprimirlo
    @Override
    public String toString() {
        return "Estudiante{numControl='" + numeroControl + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' + '}';
    }
}