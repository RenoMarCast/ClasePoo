package TDA;

// Representa a un estudiante. Existe por su cuenta, no depende del auto ni del estacionamiento.
public class Estudiante {
    private String numeroControl;
    private String nombreCompleto;

    // Constructor con todos los parametros (orden que marca el diagrama)
    public Estudiante(String numeroControl, String nombreCompleto) {
        this.numeroControl = numeroControl;
        this.nombreCompleto = nombreCompleto;
    }

    // Setters: guardan el dato en el atributo
    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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