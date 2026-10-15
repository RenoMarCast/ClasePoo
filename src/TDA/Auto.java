package TDA;

// Representa un auto (el "Vehiculo" del diagrama). Guarda una referencia al estudiante responsable (agregacion).
public class Auto {
    private String placa;
    private String marca;
    private String modelo;
    private Estudiante estudiante;   // referencia al estudiante responsable, no una copia

    // Constructor: el orden de parametros es el que marca el diagrama
    public Auto(String placa, String marca, String modelo, Estudiante estudiante) {
        setPlaca(placa);
        setMarca(marca);
        setModelo(modelo);
        setEstudiante(estudiante);
    }

    // Setters con validacion: evitan que se guarden datos vacios

    // La placa identifica al auto, por eso no puede estar vacia
    public void setPlaca(String placa) {
        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        this.placa = placa.trim();
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isBlank())
            throw new IllegalArgumentException("La marca no puede estar vacía.");
        this.marca = marca.trim();
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.isBlank())
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        this.modelo = modelo.trim();
    }

    // Todo auto debe tener un estudiante responsable
    public void setEstudiante(Estudiante estudiante) {
        if (estudiante == null)
            throw new IllegalArgumentException("El auto debe tener un estudiante responsable.");
        this.estudiante = estudiante;
    }

    // Getters: permiten leer los atributos desde otras clases
    // (por ejemplo, el estacionamiento usa getPlaca para buscar repetidas)
    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public Estudiante getEstudiante() { return estudiante; }

    // Convierte el auto (y su estudiante) a texto para imprimirlo
    @Override
    public String toString() {
        return "Auto{placa='" + placa + "', marca='" + marca + "', modelo='" + modelo + "', " + estudiante + "}";
    }
}