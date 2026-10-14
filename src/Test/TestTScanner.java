/*package Test;
import TDA.Auto;
import Tools.TJOption;
import Tools.TScanner;//llama a la otra clase se hizo en otra clase para compartir con otras clases

import java.util.InputMismatchException;

public class TestTScanner {
    public static void main(String[] args) {
        // unidad ejecutable

        menuBotonLista();
        String dato = TJOption.leerNombre("Escribe un nombre");


    }


    /
        // usar una estructura repetitiva

        byte resp=0;//aqui se inicializó
        String unir=" ";
        do{
            unir+=creaObjAuto()+"\n";
            resp=TScanner.leerByte("para continuar cualquier numero, para continuar para salir-33");

        }while(resp!=-33);
        TScanner.salidaPantalla("datos capturados:\n"+unir);

    }


    public static String creaObjAuto() {

        Auto objeto = new Auto();
//capturar datos para cada dato miembro
        objeto.setMarcaAuto(TScanner.leerString("escribe la marca del cochecito"));
        objeto.setColorAuto(TScanner.leerString("escribe el color del cochecito"));
        objeto.setModeloAuto(TScanner.leerString("escribe el modelo del cochecito"));
        objeto.setTamAuto(TScanner.leerFloat("escribe el tamaño del cochecito en cm"));
//salida a consola



        return objeto.toString();
    }
    public static void menuBotonLista()
    {
        String opcion;
        do{
            opcion=TJOption.listaDesplegable("Captura,Ordenar,Imprimir objetos, Salir");
            switch (opcion)
            {
                case "Captura": TJOption.imprimir("Captura un objeto");

                    break;
                case "Ordenar": TJOption.imprimir("Ordenar: ");
                    break;
                case "Imprimir objetos": TJOption.imprimir("Lista de objetos: ");
                    break;
                case "Salir": TJOption.imprimir("¡¡Fin del programa!!");
                    break;

            }

        }while(!opcion.equalsIgnoreCase("Salir"));
    }

}


//Mio
//Para Byte
//String dato =String.valueOf(Byte.valueOf((byte)TJOption.leerByte("Recibeun valor de entrada")));

//Para Int
//String dato = String.valueOf(Integer.valueOf(TJOption.leerInt("Recibe un valor de entrada")));

//Para Shoet
//String dato = String.valueOf(TJOption.leerShort("Recibe un valor de entrada"));

//Nombres
//String dato = TJOption.leerNombre("Nombre: ");
        /* byte resp=0;
          String unir =" ";
          do {
            //Mensaje...
            unir += creaObjAuto()+"\n";

            resp=TScanner.leerByte("Cualquier numero p/Continuar"+ "para salir -33: ");
         } while (resp != -33);
         TScanner.salidaPantalla("Datos Capturados\n" + unir);

    }

    //byte edad = TScanner.leerByte("Escribe la edad de una persona ");

//Instruccion
//Crear una instancia de la clase auto

//Tipo de dato Abstracto(TDA) indentificador = new tipo de dato abstracto(TDA)
        //EJEMPLO
        //Auto auto = new Auto();
        //Salida a consol: Ej Auto
        //TScanner.salidaPantalla(auto.tostring());


        //metodo de clase que permita almacenar datos en una instancia del objeto Auto
    public static String creaObjAuto() {
            Auto auto = new Auto();
            //Captura datos para cada miembro
            auto.setMarcaAuto(TScanner.leerString("Escribe marca del auto: "));
            auto.setColorAuto(TScanner.leerString("Escribe color del auto: "));
            auto.setModeloAuto(TScanner.leerString("Escribe modelo auto: "));
            auto.setTamAuto(TScanner.leerFloat("Escribe tamaño auto en cm: "));

            //Salida de consola: Auto ... constructor vacio\
            return auto.informacion();
        }
        public static void capturaObjetos(){
        byte resp =0;
        String unir =" ";
        for (;resp != 33;){
            unir += creaObjAuto()+"\n";
            resp = TScanner.leerByte("Cualquier numero p/Continuar," + "para salir -33: ");
        }
        TScanner.salidaPantalla("Datos capturados:\n"+unir);
        }
        public static void menuObjetos(){
        byte opcion;
        do {
            opcion = TScanner.seleccionOpcion("Captura,Imprimir objetos,Salir");

            switch (opcion) {
                        case 1:
                            TScanner.salidaPantalla("Captura de Objetos");
                            break;

                        case 2:
                            TScanner.salidaPantalla("Listar Objetos");
                            break;

                        case 3:
                            TScanner.salidaPantalla("Fin de Programa !!!!");
                            break;

                        default:
                            TScanner.msjeError("Opcion no definida.... Intente de nuevo");
                    }
                }
                while (opcion != 3) ;

            }
        }

         */
