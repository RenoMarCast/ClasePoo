package Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TScanner {
    public static void msjeError(String msje)
    {


        String cad="_".repeat(20)+"\n";
        cad+=NEGRITA+AZUL+msje+"\n"+RESET;
        cad+="_".repeat(20);
        System.out.println(cad);


        cad="_".repeat(20)+"\n";
        cad+=NEGRITA+ROJO+msje+"\n"+RESET;
        cad+="_".repeat(20);
        System.out.println(cad);

    }
    //valores constantes de colores
    //valores constantes en hexadecimal
    static final String ROJO="\u001B[31m";
    static final String RESET="\u001B[0m";
    static final String AZUL="\u001B[34m";
    static final String NEGRITA="\u001B[1m";
    static final String VERDE="\u001B[32m";
    public static final String CYAN="\u001B[36m";
    static Scanner leer = new Scanner(System.in);

    //metodos de clase para entrada y salida de datos usando consola
    //recibe un mensaje parametros, titulo de acuerdo a lo que hace tipo de dato porque va a retornar
    public static byte leerByte(String msje) {
        System.out.print(msje);
        return leer.nextByte();
        //recibe como parametro un mensaje regresa el valor se agrupo
    }

    //short, int, long
    public static short leerShort(String msje) {
        System.out.print(msje);
        return leer.nextShort();
    }

    public static int leerInt(String msje) {
        while(true){
            try {
                System.out.print(NEGRITA+AZUL+msje+"rango("+Integer.MIN_VALUE+".."+Integer.MAX_VALUE+"):=>"+RESET);
                return leer.nextInt();
            }catch (InputMismatchException e){
                msjeError(
                        "Dato incorrecto. solo se admiten numeros"
                                + "en el rango de" + Integer.MAX_VALUE+"a"+Integer.MAX_VALUE+"."
                );
                leer.next();//elimina la entrada incorrecta
            }
        }
    }

    public static long leerLong(String msje) {
        System.out.print(msje);
        return leer.nextLong();
    }


    public static float leerFloat(String msje) {
        System.out.print(msje);
        return leer.nextFloat();
    }

    //cadena, char
    public static char leerChar(String msje) {
        System.out.print(msje);
        return leer.next().charAt(0);//toma el primer caracter por eso cero y no necesita llamar y no se puede cambiar

    }
    public static void limpiabuffer()
    {
        leer.nextLine();
        leer.close();
    }
    public static void salidaPantalla(String msje) {
        System.out.println(msje);
    }
    public static String leerString(String msje) {
        System.out.print(msje);
        return leer.next();
    }
    public static byte select(String opciones)
    {
        //convierte la cadena a un array para separar las opciones del menu
        String seleccion[]=opciones.split(",");
        String unir=" ".repeat(15)+NEGRITA+CYAN+"M E N U\n";
        unir+="-".repeat(40)+"\n";
        for(byte i=0; i< seleccion.length; i++)
        {
            unir+="\t"+NEGRITA+AZUL+((i+1)+"."+ seleccion[1].toUpperCase())+RESET+"\n";

        }
        unir+="-".repeat(40)+"\n";

        salidaPantalla(unir);


        byte opcion=TScanner.leerByte(NEGRITA+VERDE+"seleccione una opcion"+RESET);
        return (byte)(opcion);
    }


    public static double leerDouble(String msje)
    {
        System.out.print(msje);
        return leer.nextDouble();
    }

    public static String leerNombre(String msje){

        while (true){

            System.out.print(msje);
            String texto = leer.nextLine();

            if (texto.isBlank()){
                msjeError("Error: debe ingresar al menos un nombre.");
            }else if(!texto.matches("\\p{L}+(?:\\p{L}+)")){
                msjeError("Error: solo se permiten letras y espacios entre nombres");
            }else{
                return texto;
            }

        }

    }

}