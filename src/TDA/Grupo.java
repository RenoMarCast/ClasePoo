//package TDA;
//
//import Memoria.ArrayEstatico;
//
//public class Grupo {
//
//    public static final byte CAPACIDAD_MAXIMA = 15;
//
//    private String clave;
//    private String nombreCurso;
//    private ArrayEstatico estudiantes;   // array estático de referencias (agregación)
//
//    public Grupo(String clave, String nombreCurso) {
//        if (clave == null || clave.isBlank()) {
//            throw new IllegalArgumentException("La clave del grupo no puede estar vacía.");
//        }
//        if (nombreCurso == null || nombreCurso.isBlank()) {
//            throw new IllegalArgumentException("El nombre del curso no puede estar vacío.");
//        }
//        this.clave = clave.trim();
//        this.nombreCurso = nombreCurso.trim();
//        this.estudiantes = new ArrayEstatico(CAPACIDAD_MAXIMA);
//    }
//
//    public String getClave() {
//        return clave;
//    }
//
//    public byte getTotalEstudiantes() {
//        return estudiantes.total();
//    }
//
//    public boolean empty() {
//        return estudiantes.empty();
//    }
//
//    public boolean full() {
//        return estudiantes.full();
//    }
//
//    // Recibe un estudiante que ya existe y guarda su referencia
//    public void agregarEstudiante(Estudiante e) {
//        if (e == null) {
//            throw new IllegalArgumentException("El estudiante no puede ser nulo.");
//        }
//        if (full()) {
//            throw new IllegalStateException("El grupo " + clave
//                    + " ya alcanzó su capacidad máxima de " + CAPACIDAD_MAXIMA + " estudiantes.");
//        }
//        if (estudiantes.busSecuencial(e.getNumeroDeControl()) != -2) {
//            throw new IllegalArgumentException("Ese número de control ya está en el grupo " + clave + ".");
//        }
//        estudiantes.addObjeto(e);
//    }
//
//    @Override
//    public String toString() {
//        String texto = "Grupo: " + clave + " | Curso: " + nombreCurso
//                + " | Estudiantes: " + getTotalEstudiantes() + "/" + CAPACIDAD_MAXIMA + "\n\n";
//        if (empty()) {
//            return texto + "(sin estudiantes)";
//        }
//        return texto + estudiantes.listado();
//    }
//}