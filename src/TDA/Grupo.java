package TDA;

import Memoria.ArrayEstatico;
import Tools.TJOption;

public class Grupo {

    public static final byte CAPACIDAD_MAXIMA = 15;

    // Declaro también como constante el máximo de grupos que se pueden crear (valor arbitrario de 15).
    private static final byte LIMITE_GRUPOS = 15;

    // Creo un arreglo estático de grupos; es static porque pertenece a la clase y no a un grupo en particular.
    private static Grupo[] listaGrupos = new Grupo[LIMITE_GRUPOS];

    // Guardo cuántos grupos llevo creados; empieza en 0 porque al inicio no hay ninguno.
    private static byte totalGrupos = 0;


    // La clave identifica al grupo; es private para que nadie la cambie desde fuera (encapsulamiento).
    private String clave;

    // Guardo el nombre del curso que representa este grupo.
    private String nombreCurso;

    private Estudiante[] estudiantes;

    // Llevo la cuenta de cuántos estudiantes tiene este grupo para saber dónde agregar y cuándo se llena.
    private byte total;

    // Constructor: recibe solo los datos que sí conozco al crear el grupo (clave y curso).
    public Grupo(String clave, String nombreCurso) {
        // Valido que la clave no llegue nula ni vacía, porque no quiero grupos sin identificar.
        if (clave == null || clave.isBlank()) {
            // Lanzo una excepción porque un grupo sin clave es un error
            throw new IllegalArgumentException("La clave del grupo no puede estar vacía.");
        }
        // Hago la misma validación con el nombre del curso.
        if (nombreCurso == null || nombreCurso.isBlank()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío.");
        }
        // Guardo la clave quitando espacios sobrantes con trim().
        this.clave = clave.trim();
        // Guardo el nombre del curso también sin espacios sobrantes.
        this.nombreCurso = nombreCurso.trim();
        // Creo el arreglo con 15 espacios; solo guarda referencias, todavía no hay ningún estudiante.
        this.estudiantes = new Estudiante[CAPACIDAD_MAXIMA];
        // Inicio la cuenta en 0 porque el grupo nace vacío.
        this.total = 0;
    }

    // Getter de la clave: lo necesito para comparar claves al buscar y para mostrar mensajes.
    public String getClave() {
        return clave;
    }

    // Getter del total: lo uso para decir cuántos estudiantes lleva el grupo (por ejemplo 3/15).
    public byte getTotalEstudiantes() {
        return total;
    }

    // Método auxiliar: me dice si el grupo ya llegó al máximo; evito repetir esta comparación en varios lados.
    private boolean estaLleno() {
        return total == CAPACIDAD_MAXIMA;
    }

    // Busco un estudiante dentro de ESTE grupo por número de control; sirve para no meterlo dos veces.
    private byte buscarEstudiante(String numControl) {
        // Recorro solo hasta 'total' porque lo demás del arreglo está vacío (null).
        for (byte i = 0; i < total; i++) {
            // Comparo el número de control con equals porque es un String.
            if (estudiantes[i].getNumeroDeControl().equals(numControl)) {
                // Si lo encuentro devuelvo la posición.
                return i;
            }
        }
        // Uso -2 como "no encontrado", igual que en mis otros busSecuencial.
        return -2;
    }

    // Agrego la referencia de un estudiante ya existente (aquí está la agregación).
    private void agregarEstudiante(Estudiante e) {
        // Valido que me llegue un estudiante real para evitar un NullPointerException más adelante.
        if (e == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo.");
        }
        // Reviso el límite de 15 ANTES de agregar; si ya está lleno no dejo continuar.
        if (estaLleno()) {
            throw new IllegalStateException("El grupo " + clave
                    + " ya alcanzó su capacidad máxima de " + CAPACIDAD_MAXIMA + " estudiantes.");
        }
        // Reviso que el estudiante no esté ya en este grupo para no duplicarlo.
        if (buscarEstudiante(e.getNumeroDeControl()) != -2) {
            throw new IllegalArgumentException("El estudiante ya está en el grupo " + clave + ".");
        }
        // Guardo la REFERENCIA (no una copia) en la primera posición libre.
        estudiantes[total] = e;
        // Aumento la cuenta porque ahora hay un estudiante más.
        total++;
    }

    // Construyo el texto de un grupo (datos + sus estudiantes) para poder mostrarlo.
    private String detalle() {
        // Uso StringBuilder porque voy a concatenar muchas veces y es más eficiente que usar +.
        StringBuilder sb = new StringBuilder();
        // Pongo clave, curso y ocupación (ej. 3/15) en la primera línea.
        sb.append("Grupo: ").append(clave)
                .append(" | Curso: ").append(nombreCurso)
                .append(" | Estudiantes: ").append(total)
                .append("/").append(CAPACIDAD_MAXIMA).append("\n");
        // Si no hay estudiantes lo digo claro, en vez de mostrar un espacio en blanco.
        if (total == 0) {
            sb.append("   (sin estudiantes)\n");
        } else {
            // Si hay estudiantes, los recorro solo hasta 'total'.
            for (byte i = 0; i < total; i++) {
                // Los numero desde 1 porque así se lee mejor para una persona.
                sb.append("   ").append(i + 1).append(". ").append(estudiantes[i]).append("\n");
            }
        }
        // Devuelvo el texto ya armado.
        return sb.toString();
    }
    // Lo uso en Main para saber si ya hay grupos antes de asignar o mostrar.
    public static boolean hayGrupos() {
        return totalGrupos > 0;
    }

    // Busco un grupo por clave en el arreglo de grupos y devuelvo su posición.
    private static byte buscarGrupo(String clave) {
        // Recorro solo los grupos creados (0 hasta totalGrupos - 1).
        for (byte i = 0; i < totalGrupos; i++) {
            // Uso equalsIgnoreCase para que "A1" y "a1" cuenten como la misma clave.
            if (listaGrupos[i].clave.equalsIgnoreCase(clave)) {
                return i;
            }
        }
        // -2 significa que no existe, igual que en mis otros métodos de búsqueda.
        return -2;
    }

    // Opción "Crear grupo" del menú.
    public static void crearGrupo() {
        // Primero reviso si hay espacio en el arreglo; si no, aviso y salgo con return.
        if (totalGrupos == LIMITE_GRUPOS) {
            TJOption.imprimeError("No hay espacio para más grupos");
            return;
        }
        // Declaro la clave afuera del ciclo para poder usarla después de salir de él.
        String clave;
        // Uso un ciclo infinito que solo termina (break) cuando la clave es válida y no está repetida.
        while (true) {
            // Pido la clave con leerAlfanumerico para que no quede vacía ni lleve símbolos.
            clave = TJOption.leerAlfanumerico("Clave del grupo");
            // Si buscarGrupo devuelve -2 la clave está libre y salgo del ciclo.
            if (buscarGrupo(clave) == -2) {
                break;
            }
            // Si ya existe aviso y el ciclo vuelve a pedirla.
            TJOption.imprimeError("Ya existe un grupo con esa clave.");
        }
        // Pido el nombre del curso; leerString ya no permite dejarlo vacío.
        String curso = TJOption.leerString("Nombre del curso");
        // Creo el grupo y lo guardo en la primera posición libre (totalGrupos).
        listaGrupos[totalGrupos] = new Grupo(clave, curso);
        // Aumento el contador porque ya hay un grupo más.
        totalGrupos++;
        // Confirmo al usuario que se creó.
        TJOption.imprimirDatos("Grupo creado correctamente.");
    }

    // Opción "Asignar estudiante" del menú; recibo el arreglo de estudiantes para buscar en él.
    public static void asignarEstudiante(ArrayEstatico estudiantes) {
        // Pido la clave del grupo y busco su posición.
        byte g = buscarGrupo(TJOption.leerAlfanumerico("Clave del grupo"));
        // Si es -2 el grupo no existe, aviso y termino con return.
        if (g == -2) {
            TJOption.imprimeError("No existe ese grupo");
            return;
        }
        // Busco al estudiante en el arreglo general con el busSecuencial que ya tenía.
        byte p = estudiantes.busSecuencial(TJOption.leerAlfanumerico("Numero de control del estudiante"));
        // Si no existe, aviso que primero hay que capturarlo (el estudiante debe existir antes del grupo).
        if (p == -2) {
            TJOption.imprimeError("No existe ese estudiante. Captúralo primero.");
            return;
        }
        // Uso try/catch porque agregarEstudiante lanza excepciones cuando el grupo está lleno o hay duplicado.
        try {
            // Le paso la referencia del estudiante al grupo (no se copia, es el mismo objeto).
            listaGrupos[g].agregarEstudiante(estudiantes.getEstudiante(p));
            // Confirmo y muestro cuántos lleva el grupo (por ejemplo 4/15).
            TJOption.imprimirDatos("Estudiante agregado al grupo " + listaGrupos[g].clave
                    + " (" + listaGrupos[g].total + "/" + CAPACIDAD_MAXIMA + ")");
        } catch (IllegalArgumentException | IllegalStateException e) {
            // Muestro el mensaje de la excepción para que el usuario sepa exactamente qué pasó.
            TJOption.imprimeError(e.getMessage());
        }
    }

    // Opción "Mostrar grupos" del menú.
    public static void mostrarGrupos() {
        // Armo todo el texto en un StringBuilder para mostrarlo en una sola ventana.
        StringBuilder sb = new StringBuilder();
        // Recorro solo los grupos creados.
        for (byte i = 0; i < totalGrupos; i++) {
            // Agrego el detalle de cada grupo y una línea en blanco para separarlos.
            sb.append(listaGrupos[i].detalle()).append("\n");
        }
        // Muestro todo junto.
        TJOption.imprimir("Grupos capturados\n" + sb);
    }

    // Defino toString para que si imprimo un grupo salga su información y no una dirección de memoria.
    @Override
    public String toString() {
        return detalle();
    }
}