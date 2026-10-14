package TDA;

public class Estudiante {
    // public static final double CAL_MIN = 0;    // ya no se usa
    // public static final double CAL_MAX = 100;  // ya no se usa

    private String nombre;
    private String numeroDeControl;
    // private double promedio;                   // ya no se usa

    public Estudiante(String nombre, String numeroDeControl) {
        setNombre(nombre);
        setNumeroDeControl(numeroDeControl);
    }

    /* Comentado porque ya no se usa:
    public Estudiante() { ... }
    public Estudiante(String nombre, String numeroDeControl, double promedio) { ... }
    public void setCalificacion(double promedio) { ... }
    public double getPromedio() { ... }
    */

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public void setNumeroDeControl(String numeroDeControl) {
        if (numeroDeControl == null || numeroDeControl.isBlank()) {
            throw new IllegalArgumentException("El número de control no puede estar vacío.");
        }
        this.numeroDeControl = numeroDeControl.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroDeControl() {
        return numeroDeControl;
    }

    @Override
    public String toString() {
        return "Estudiante{numControl='" + numeroDeControl + '\'' +
                ", nombre='" + nombre + '\'' + '}';
    }
}