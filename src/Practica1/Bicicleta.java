package Practica1;

import Tools.TJOption;

public class Bicicleta {

    // atributos encapsulados
    private String codigoBici;
    private String marcaBici;
    private String tipoBici;
    private double kmRecorridos;
    private byte mesessinServicio;
    private double costoBaseMant;
    private String fechaCompra;
    private double costoBici;
    private boolean enUso;

    // Constructor sin parametros
    public Bicicleta() {
    }

    // Constructor con los datos esenciales
    public Bicicleta(String codigo, String marca, String tipo) {
        codigoBici = codigo;
        marcaBici = marca;
        tipoBici = tipo;
    }

    // Constructor con todos los atributos
    public Bicicleta(String codigoBici, String marcaBici, String tipoBici, double kmRecorridos,
                     byte mesessinServicio, double costoBaseMant, String fechaCompra,
                     double costoBici, boolean enUso) {
        this.codigoBici = codigoBici;
        this.marcaBici = marcaBici;
        this.tipoBici = tipoBici;
        this.kmRecorridos = kmRecorridos;
        this.mesessinServicio = mesessinServicio;
        this.costoBaseMant = costoBaseMant;
        this.fechaCompra = fechaCompra;
        this.costoBici = costoBici;
        this.enUso = enUso;
    }

    // Setters
    public void setCodigo(String codigo) {
        this.codigoBici = codigo;
    }

    public void setMarca(String marcaBici) {
        this.marcaBici = marcaBici;
    }

    public void setTipoBici(String tipoBici) {
        this.tipoBici = tipoBici;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public void setMesessinServicio(byte mesessinServicio) {
        this.mesessinServicio = mesessinServicio;
    }

    public void setCostoBaseMant(double costoBaseMant) {
        this.costoBaseMant = costoBaseMant;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCostoBici(double costoBici) {
        this.costoBici = costoBici;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    // Getters
    public String getCodigo() {
        return codigoBici;
    }

    public String getMarca() {
        return marcaBici;
    }

    public String getTipoBici() {
        return tipoBici;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }

    public byte getMesessinServicio() {
        return mesessinServicio;
    }

    public double getCostoBaseMant() {
        return costoBaseMant;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public double getCostoBici() {
        return costoBici;
    }

    public boolean isEnUso() {
        return enUso;
    }

    // Decide si la bici necesita mantenimiento (ajusta los umbrales a tu enunciado)
    public boolean necesitaMantenimiento() {
        return kmRecorridos >= 500 || mesessinServicio >= 6;
    }

    public double calcularCostoMant() {
        if (necesitaMantenimiento()) {
            double costo = 0;

            switch (this.tipoBici) {
                case "Urbana":
                    costo = costoBaseMant;
                    break;
                case "Montaña":
                    costo = costoBaseMant * 1.20;
                    break;
                case "Electrica":
                    costo = costoBaseMant * 1.40;
                    break;
                default:
                    costo = costoBaseMant;
            }
            return costo;
        } else
            return 0.0;
    }

    // Agrega kilometros
    public void registrarRecorrido(double kilometros) {
        if (enUso)
            kmRecorridos += kilometros;
        else
            TJOption.imprimeError("La Bicicleta No Se Encuentra En Uso");
    }

    // Realizar mantenimiento
    public void realizarMantenimiento() {
        kmRecorridos = 0.0;
        mesessinServicio = 0;
    }

    // toString
    @Override
    public String toString() {
        String necesita;
        if (necesitaMantenimiento())
            necesita = "Sí";
        else
            necesita = "No";

        String uso;
        if (enUso)
            uso = "Sí";
        else
            uso = "No";

        return "Código: " + codigoBici
                + "\nMarca: " + marcaBici
                + "\nTipo: " + tipoBici
                + "\nFecha de compra: " + fechaCompra
                + "\nCosto: $" + costoBici
                + "\nKm Recorridos: " + kmRecorridos
                + "\nMeses Sin Servicio: " + mesessinServicio
                + "\nCosto Base del Mantenimiento: $" + costoBaseMant
                + "\nEn Uso: " + uso
                + "\nNecesita Mantenimiento: " + necesita
                + "\nCosto del Mantenimiento: $" + calcularCostoMant();
    }
}