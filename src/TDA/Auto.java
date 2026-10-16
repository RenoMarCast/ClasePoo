package TDA;

public class Auto {
    private String placa;
    private String marca;
    private String modelo;
    private Estudiante estudiante;   // referencia al estudiante responsable, no una copia

    // Constructor vacio: crea el auto sin datos
    public Auto() {

    }

    // Constructor con todos los parametros
    public Auto(String placa, String marca, String modelo, Estudiante estudiante) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.estudiante = estudiante;
    }

    // Setters (encapsulamiento): guardan el dato en el atributo
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    // Getters: permiten leer los atributos desde otras clases
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    // Convierte el auto (y su estudiante) a texto para imprimirlo
    @Override
    public String toString() {
        return "Auto{placa='" + placa + "', marca='" + marca + "', modelo='" + modelo + "', " + estudiante + "}";
    }
}