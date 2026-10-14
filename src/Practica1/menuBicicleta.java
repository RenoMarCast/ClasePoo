package Practica1;

import Tools.TJOption;

import javax.swing.*;

public class menuBicicleta {

    // Pide los km y vuelve a preguntar hasta que el dato sea un número válido y no negativo
    private static double leerKm() {
        while (true) {
            try {
                double km = Double.parseDouble(JOptionPane.showInputDialog("Km recorridos:"));

                if (km < 0)
                    TJOption.imprimeError("Los kilómetros no pueden ser negativos. Intenta de nuevo");
                else
                    return km;

            } catch (NumberFormatException | NullPointerException e) {
                TJOption.imprimeError("Escribe un número válido");
            }
        }
    }

    public static void menuBici() {

        String opcion;
        Bicicleta bici = new Bicicleta();

        do {
            opcion = TJOption.listaDesplegable(
                    "Capturar,Mostrar,Mantenimientos,Salir"
            );

            switch (opcion) {

                case "Capturar":
                    TJOption.imprimir("Capturar Bicicleta");

                    bici.setCodigo(JOptionPane.showInputDialog("Código:"));
                    bici.setMarca(JOptionPane.showInputDialog("Marca:"));
                    bici.setTipoBici(TJOption.listaDesplegable("Urbana,Montaña,Electrica"));
                    bici.setFechaCompra(JOptionPane.showInputDialog("Fecha de compra:"));
                    bici.setCostoBici(Double.parseDouble(JOptionPane.showInputDialog("Costo:")));
                    bici.setKmRecorridos(leerKm());
                    bici.setMesessinServicio(Byte.parseByte(JOptionPane.showInputDialog("Meses sin servicio:")));
                    bici.setCostoBaseMant(Double.parseDouble(JOptionPane.showInputDialog("Costo base de mantenimiento:")));
                    bici.setEnUso(TJOption.siNo("¿Está en uso?") == 0);
                    break;

                case "Mostrar":
                    if (bici.getCodigo() == null)
                        TJOption.imprimeError("Primero captura una bicicleta");
                    else
                        TJOption.imprimir(bici.toString());
                    break;

                case "Mantenimientos":
                    if (bici.getCodigo() == null)
                        TJOption.imprimeError("Primero captura una bicicleta");
                    else if (bici.necesitaMantenimiento())
                        TJOption.imprimir("Necesita mantenimiento. Costo: $" + bici.calcularCostoMant());
                    else
                        TJOption.imprimir("No necesita mantenimiento");
                    break;

                case "Salir":
                    TJOption.imprimir("FIN DE PROGRAMA");
                    break;
            }

        } while (!opcion.equalsIgnoreCase("Salir"));
    }
}