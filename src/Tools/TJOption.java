package Tools;

import javax.swing.*;

public class TJOption {
    // metodos de clase para entradas de datos con ventanas emergentes

    // ---------- Base: pide texto y NO deja continuar si esta vacio o se cancela ----------
    private static String pedirNoVacio(String msje, String titulo) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, msje, titulo, JOptionPane.QUESTION_MESSAGE);
            if (texto == null || texto.isBlank()) {
                imprimeError("El campo no puede quedar vacío.");
            } else {
                return texto.trim();
            }
        }
    }

    // ---------- Numericos ----------
    public static byte leerByte(String msje) {
        while (true) {
            try {
                return Byte.parseByte(pedirNoVacio(msje, "Byte " + Byte.MIN_VALUE + " a " + Byte.MAX_VALUE));
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten enteros en el rango " + Byte.MIN_VALUE + " a " + Byte.MAX_VALUE);
            }
        }
    }

    /** Byte dentro de un rango (ej. tamaño del array entre 1 y 127). */
    public static byte leerByteRango(String msje, byte min, byte max) {
        while (true) {
            byte valor = leerByte(msje + " (" + min + " a " + max + ")");
            if (valor >= min && valor <= max) {
                return valor;
            }
            imprimeError("El valor debe estar entre " + min + " y " + max);
        }
    }

    public static short leerShort(String msje) {
        while (true) {
            try {
                return Short.parseShort(pedirNoVacio(msje, "Short " + Short.MIN_VALUE + " a " + Short.MAX_VALUE));
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten enteros en el rango " + Short.MIN_VALUE + " a " + Short.MAX_VALUE);
            }
        }
    }

    public static int leerInt(String msje) {
        while (true) {
            try {
                return Integer.parseInt(pedirNoVacio(msje, "Int " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE));
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten enteros en el rango " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);
            }
        }
    }

    public static long leerLong(String msje) {
        while (true) {
            try {
                return Long.parseLong(pedirNoVacio(msje, "Long " + Long.MIN_VALUE + " a " + Long.MAX_VALUE));
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten enteros en el rango " + Long.MIN_VALUE + " a " + Long.MAX_VALUE);
            }
        }
    }

    public static float leerFloat(String msje) {
        while (true) {
            try {
                float valor = Float.parseFloat(pedirNoVacio(msje, "Float"));
                if (Float.isNaN(valor) || Float.isInfinite(valor)) {
                    throw new NumberFormatException();
                }
                return valor;
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten números válidos.");
            }
        }
    }

    public static double leerDouble(String msje) {
        while (true) {
            try {
                double valor = Double.parseDouble(pedirNoVacio(msje, "Double"));
                if (Double.isNaN(valor) || Double.isInfinite(valor)) {
                    throw new NumberFormatException();
                }
                return valor;
            } catch (NumberFormatException e) {
                imprimeError("Solo se admiten números válidos (ej. 85.5).");
            }
        }
    }

    /** Double dentro de un rango. Ideal para calificaciones (sin negativos). */
    public static double leerDoubleRango(String msje, double min, double max) {
        while (true) {
            double valor = leerDouble(msje + " (" + min + " a " + max + ")");
            if (valor >= min && valor <= max) {
                return valor;
            }
            imprimeError("El valor debe estar entre " + min + " y " + max);
        }
    }

    // ---------- Texto ----------
    /** Texto cualquiera, pero obligatorio (no vacio). */
    public static String leerString(String msje) {
        return pedirNoVacio(msje, "Cadena");
    }

    public static char leerChar(String msje) {
        return pedirNoVacio(msje, "Carácter").charAt(0);
    }

    /** Solo letras y espacios entre palabras (acepta acentos y ñ). */
    public static String leerNombre(String msje) {
        while (true) {
            String texto = pedirNoVacio(msje, "Ingresa un nombre");
            if (!texto.matches("\\p{L}+(?:\\s+\\p{L}+)*")) {
                imprimeError("Error: solo se permiten letras y espacios entre nombres.");
            } else {
                return texto;
            }
        }
    }

    /** Letras y numeros, sin espacios ni simbolos (numero de control, clave de grupo). */
    public static String leerAlfanumerico(String msje) {
        while (true) {
            String texto = pedirNoVacio(msje, "Dato alfanumérico");
            if (!texto.matches("[\\p{L}\\p{N}]+")) {
                imprimeError("Error: solo letras y números, sin espacios ni símbolos.");
            } else {
                return texto;
            }
        }
    }

    // ---------- Menus ----------
    public static byte select(String opciones) {
        // convierte la cadena a un array para separar las opciones del menu
        String seleccion[] = opciones.split(",");

        String unir = " ".repeat(15) + "M E N U\n";
        unir += "-".repeat(40) + "\n";
        for (byte i = 0; i < seleccion.length; i++) {
            unir += "\t" + ((i + 1) + "." + seleccion[i].toUpperCase()) + "\n";
        }
        unir += "-".repeat(40) + "\n";

        byte opcion = TJOption.leerByte(unir + "Seleccione una opcion");
        return opcion;
    }

    /** Devuelve la opcion elegida, o "Salir" si el usuario cierra/cancela la ventana. */
    public static String listaDesplegable(String menu) {
        String valores[] = menu.split(",");
        String res = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion de la lista: ", "M E N U",
                JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
        return (res == null) ? "Salir" : res;
    }

    public static String botonOpciones(String menu) {
        String valores[] = menu.split(",");
        int n = JOptionPane.showOptionDialog(null, "M E N U", "SELECCIONA DANDO CLICK-BOTÓN",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
        return (n >= 0) ? valores[n] : null;
    }

    // ---------- Salidas ----------
    public static void imprimirDatos(String msje) {
        JOptionPane.showMessageDialog(null, msje, "Salida", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void imprimir(String msje) {
        JOptionPane.showMessageDialog(null, msje, "SALIDA", JOptionPane.PLAIN_MESSAGE);
    }

    public static void imprimeError(String msje) {
        JOptionPane.showMessageDialog(null, msje, "ERROR!", JOptionPane.ERROR_MESSAGE);
    }

    public static byte siNo(String msje) {
        return (byte) JOptionPane.showConfirmDialog(null, msje,
                "Confirmar presionando un botón", JOptionPane.YES_NO_OPTION);
    }
}