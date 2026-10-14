package TDA;

public class Estudiante {
    // Rango valido de calificacion (cambialo aqui si tu escala es 0-10)
    public static final double CAL_MIN = 0;
    public static final double CAL_MAX = 100;

    private String nombre;
    private String numeroDeControl;
    private double promedio;

    public Estudiante() {
        this.numeroDeControl = "";
        this.nombre = "";
        this.promedio = 0.0;
    }

    public Estudiante(String nombre, String numeroDeControl, double promedio) {
        setNombre(nombre);
        setNumeroDeControl(numeroDeControl);
        setCalificacion(promedio);
    }

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

    public void setCalificacion(double promedio) {
        if (Double.isNaN(promedio) || promedio < CAL_MIN || promedio > CAL_MAX) {
            throw new IllegalArgumentException(
                    "La calificación debe estar entre " + CAL_MIN + " y " + CAL_MAX + ".");
        }
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public String getNumeroDeControl() {
        return numeroDeControl;
    }

    @Override
    public String toString() {
        return "Estudiante{numControl='" + numeroDeControl + '\'' +
                ", nombre='" + nombre + '\'' +
                ", promedio=" + promedio +
                '}';
    }
}