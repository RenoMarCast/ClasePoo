/*
package Practica2;

import javax.swing.JOptionPane;
import Tools.TJOption;

public class PruebaProductoDespensa {

    // Se repite con while(true) hasta que el usuario escriba algo válido.
    private static byte leerByte(String mensaje, int min, int max) {
        while (true) {
            try {
                // Convierte el texto escrito a byte (si pasa de 127 o trae letras, lanza error)
                byte numero = Byte.parseByte(JOptionPane.showInputDialog(mensaje));

                // Si está fuera del rango permitido, avisa y vuelve a preguntar
                if (numero < min || numero > max)
                    TJOption.imprimeError("Debe estar entre " + min + " y " + max);
                else
                    return numero; // dato válido: sale del ciclo y lo regresa

            } catch (NumberFormatException | NullPointerException e) {
                // NumberFormatException: letras o número fuera de byte. NullPointerException: dio Cancelar
                TJOption.imprimeError("Escribe un número entero válido (máximo 127)");
            }
        }
    }

    //pide el precio y exige que sea mayor que 0
    private static double leerPrecio() {
        while (true) {
            try {
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio unitario:"));

                if (precio <= 0)
                    TJOption.imprimeError("El precio debe ser mayor que 0");
                else
                    return precio;

            } catch (NumberFormatException | NullPointerException e) {
                TJOption.imprimeError("Escribe un número válido");
            }
        }
    }

    public static void main(String[] args) {

        String opcion;

        // Se crea el objeto con el constructor vacío
        ProductoDespensa producto = new ProductoDespensa();

        // El menú se repite hasta que el usuario elija "Salir"
        do {
            opcion = TJOption.listaDesplegable(
                    "Capturar,Mostrar,Reabastecimiento,Salir"
            );

            switch (opcion) {

                case "Capturar":
                    TJOption.imprimir("Capturar Producto");

                    // Cada dato se guarda en el objeto usando sus setters
                    producto.setCodigo(JOptionPane.showInputDialog("Código:"));
                    producto.setNombre(JOptionPane.showInputDialog("Nombre:"));
                    // Lista desplegable: así la categoría siempre coincide con las del cálculo
                    producto.setCategoria(TJOption.listaDesplegable("Alimento,Limpieza,Higiene"));
                    producto.setCantidadDisponible(leerByte("Cantidad disponible:", 0, 127));
                    producto.setCantidadMinima(leerByte("Cantidad mínima (1 a 19):", 1, 19));
                    producto.setPrecioUnitario(leerPrecio());
                    break;

                case "Mostrar":
                    // El código por defecto es " ", con trim() detectamos que no hay captura
                    if (producto.getCodigo().trim().isEmpty())
                        TJOption.imprimeError("Primero captura un producto");
                    else
                        TJOption.imprimir(producto.toString()); // usa el toString de la clase
                    break;

                case "Reabastecimiento":
                    if (producto.getCodigo().trim().isEmpty()) {
                        TJOption.imprimeError("Primero captura un producto");
                    } else {
                        // Se vuelve a preguntar cuántos productos hay en existencia ahora,
                        // porque la cantidad pudo cambiar desde que se capturó
                        producto.setCantidadDisponible(
                                leerByte("¿Cuántos hay en existencia actualmente?", 0, 127));

                        //disponible <= mínima?
                        if (producto.requiereReabastecimiento())
                            //  muestra cuánto comprar y cuánto cuesta
                            TJOption.imprimir("Necesita reabastecimiento.\nComprar: "
                                    + producto.calcularCantidadPorComprar()
                                    + " piezas\nCosto recomendado: $" + producto.calcularCostoRecomendado());
                        else
                            //si no necesita, cantidad y costo son 0
                            TJOption.imprimir("No necesita reabastecimiento.\nCantidad por comprar: "
                                    + producto.calcularCantidadPorComprar()
                                    + "\nCosto recomendado: $" + producto.calcularCostoRecomendado());
                    }
                    break;

                case "Salir":
                    TJOption.imprimir("FIN DE PROGRAMA");
                    break;
            }

        } while (!opcion.equalsIgnoreCase("Salir")); // se repite mientras no elija Salir
    }
}

 */