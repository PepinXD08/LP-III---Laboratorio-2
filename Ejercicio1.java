package vizcarra;

import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public interface Mostrable {
        void mostrarInformacion();
    }

    public static abstract class Persona implements Mostrable {
        protected String nombre;
        protected String correo;
        protected static int contadorPersonas = 0;

        public Persona(String nombre, String correo) {
            this.nombre = nombre;
            this.correo = correo;
            contadorPersonas++;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public static int getCantidadPersonas() {
            return contadorPersonas;
        }

        @Override
        public abstract void mostrarInformacion();
    }

    public static class Estudiante extends Persona {
        public static final String TIPO = "ESTUDIANTE";
        private String codigo;
        private static int contadorEstudiantes = 0;

        public Estudiante(String nombre, String correo, String codigo) {
            super(nombre, correo);
            this.codigo = codigo;
            contadorEstudiantes++;
        }

        public String getCodigo() {
            return codigo;
        }

        @Override
        public void mostrarInformacion() {
            System.out.println("Estudiante: " + nombre + " | Código: " + codigo + " | Correo: " + correo);
        }

        public static int getCantidadEstudiantes() {
            return contadorEstudiantes;
        }
    }

    public static class Profesor extends Persona {
        public static final String TIPO = "PROFESOR";
        private String especialidad;
        private static int contadorProfesores = 0;

        public Profesor(String nombre, String correo, String especialidad) {
            super(nombre, correo);
            this.especialidad = especialidad;
            contadorProfesores++;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        @Override
        public void mostrarInformacion() {
            System.out.println("Profesor: " + nombre + " | Especialidad: " + especialidad + " | Correo: " + correo);
        }

        public static int getCantidadProfesores() {
            return contadorProfesores;
        }
    }

    public static class Categoria {
        private String nombre;
        private String descripcion;
        
        public Categoria(String nombre, String descripcion) {
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }

    public static class Inscripcion {
        private Estudiante estudiante;
        private Curso curso;
        
        public Inscripcion(Estudiante estudiante, Curso curso) {
            this.estudiante = estudiante;
            this.curso = curso;
        }

        public Estudiante getEstudiante() {
            return estudiante;
        }

        public Curso getCurso() {
            return curso;
        }

        public void mostrarInformacion() {
            System.out.println(estudiante.getNombre() + " -> " + curso.getNombre());
        }
    }

    public static class Curso {
        public static final int MAX_ESTUDIANTES = 30;
        private String codigo;
        private String nombre;
        private int creditos;
        private Profesor profesor;
        private List<Inscripcion> inscripciones;
        private Categoria categoria;

        public Curso(String codigo, String nombre, int creditos, Categoria categoria) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.creditos = creditos;
            this.categoria = categoria;
            this.inscripciones = new ArrayList<>();
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCreditos() {
            return creditos;
        }

        public Profesor getProfesor() {
            return profesor;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void asignarProfesor(Profesor profesor) {
            this.profesor = profesor;
        }

        public boolean matricularEstudiante(Estudiante estudiante) {
            if (inscripciones.size() >= MAX_ESTUDIANTES) {
                System.out.println("No se puede matricular a " + estudiante.getNombre() + ". El curso está lleno.");
                return false;
            }

            for (Inscripcion inscripcion : inscripciones) {
                if (inscripcion.getEstudiante().getCodigo().equals(estudiante.getCodigo())) {
                    System.out.println(estudiante.getNombre() + " ya está matriculado en " + nombre);
                    return false;
                }
            }
            Inscripcion nuevaInscripcion = new Inscripcion(estudiante, this);
            inscripciones.add(nuevaInscripcion);
            return true;
        }

        public int getCantidadEstudiantes() {
            return inscripciones.size();
        }

        public boolean estaDisponible() {
            return inscripciones.size() < MAX_ESTUDIANTES;
        }

        public void mostrarInformacion() {
            System.out.println("Código: " + codigo);
            System.out.println("Curso: " + nombre);
            System.out.println("Créditos: " + creditos);
            System.out.println("Categoría: " + categoria.getNombre());

            if (profesor != null) {
                System.out.println("Profesor: " + profesor.getNombre());
            } else {
                System.out.println("Profesor: Sin asignar");
            }

            System.out.println("Matriculados: " + inscripciones.size() + "/" + MAX_ESTUDIANTES);
            System.out.println("Disponible: " + (estaDisponible() ? "Sí" : "No"));
        }
    }

    public static class SistemaGestion {
        public static final String NOMBRE_SISTEMA = "Sistema de Gestión de Cursos Universitarios";
        private List<Estudiante> estudiantes;
        private List<Profesor> profesores;
        private List<Curso> cursos;
        private static int cantidadSistemas = 0;
        
        public SistemaGestion() {
            estudiantes = new ArrayList<>();
            profesores = new ArrayList<>();
            cursos = new ArrayList<>();
            cantidadSistemas++;
        }

        public void registrarEstudiante(Estudiante estudiante) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante registrado: " + estudiante.getNombre());
        }

        public void registrarProfesor(Profesor profesor) {
            profesores.add(profesor);
            System.out.println("Profesor registrado: " + profesor.getNombre());
        }

        public void registrarCurso(Curso curso) {
            cursos.add(curso);
            System.out.println("Curso registrado: " + curso.getNombre());
        }

        public void asignarProfesor(Curso curso, Profesor profesor) {
            curso.asignarProfesor(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " asignado al curso " + curso.getNombre());
        }

        public void matricularEstudiante(Estudiante estudiante, Curso curso) {
            if (curso.matricularEstudiante(estudiante)) {
                System.out.println(estudiante.getNombre() + " se matriculó en " + curso.getNombre());
            }
        }

        public void mostrarCursos() {
            System.out.println("CURSOS");
            for (Curso curso : cursos) {
                curso.mostrarInformacion();
            }
        }

        public void mostrarCursosDisponibles() {
            System.out.println("CURSOS DISPONIBLES");
            boolean existeCursoDisponible = false;
            for (Curso curso : cursos) {
                if (curso.estaDisponible()) {
                    existeCursoDisponible = true;
                    System.out.println(curso.getCodigo() + " - " + curso.getNombre() + " | " + curso.getCantidadEstudiantes() + "/" + Curso.MAX_ESTUDIANTES);
                }
            }

            if (!existeCursoDisponible) {
                System.out.println("No existen cursos disponibles.");
            }
        }

        public void mostrarResumen() {
            System.out.println("RESUMEN");
            System.out.println("Estudiantes: " + estudiantes.size());
            System.out.println("Profesores: " + profesores.size());
            System.out.println("Cursos: " + cursos.size());
        }

        public static int getCantidadSistemas() {
            return cantidadSistemas;
        }
    }

    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        System.out.println(SistemaGestion.NOMBRE_SISTEMA);
        System.out.println();

        Categoria matematicas = new Categoria("Matemáticas", "Cursos relacionados con matemáticas.");
        Categoria programacion = new Categoria("Programación", "Cursos relacionados con desarrollo de software.");
        Categoria redes = new Categoria("Redes", "Cursos relacionados con redes y comunicaciones.");

        Profesor profesor1 = new Profesor("Carlos Gómez", "carlos@universidad.edu", "Matemáticas");
        Profesor profesor2 = new Profesor("Ana Torres", "ana@universidad.edu", "Programación");
        Profesor profesor3 = new Profesor("Luis Mendoza", "luis@universidad.edu", "Redes");

        sistema.registrarProfesor(profesor1);
        sistema.registrarProfesor(profesor2);
        sistema.registrarProfesor(profesor3);

        System.out.println();

        Estudiante estudiante1 = new Estudiante("Edgard Díaz", "edgard@universidad.edu", "20260001");
        Estudiante estudiante2 = new Estudiante("Juan Pérez", "juan@universidad.edu", "20260002");
        Estudiante estudiante3 = new Estudiante("María López", "maria@universidad.edu", "20260003");
        Estudiante estudiante4 = new Estudiante("Carlos Sánchez", "carlos.s@universidad.edu", "20260004");

        sistema.registrarEstudiante(estudiante1);
        sistema.registrarEstudiante(estudiante2);
        sistema.registrarEstudiante(estudiante3);
        sistema.registrarEstudiante(estudiante4);

        System.out.println();

        Curso curso1 = new Curso("MAT101", "Matemática I", 4, matematicas);
        Curso curso2 = new Curso("PROG201", "Programación II", 5, programacion);
        Curso curso3 = new Curso("RED301", "Redes de Computadoras", 4, redes);

        sistema.registrarCurso(curso1);
        sistema.registrarCurso(curso2);
        sistema.registrarCurso(curso3);

        System.out.println();

        sistema.asignarProfesor(curso1, profesor1);
        sistema.asignarProfesor(curso2, profesor2);
        sistema.asignarProfesor(curso3, profesor3);

        System.out.println();
        System.out.println("MATRICULACIONES");

        sistema.matricularEstudiante(estudiante1, curso1);
        sistema.matricularEstudiante(estudiante2, curso1);
        sistema.matricularEstudiante(estudiante3, curso1);
        sistema.matricularEstudiante(estudiante1, curso2);
        sistema.matricularEstudiante(estudiante4, curso2);
        sistema.matricularEstudiante(estudiante2, curso3);

        System.out.println();
        sistema.mostrarCursos();

        System.out.println();
        sistema.mostrarCursosDisponibles();

        System.out.println();
        sistema.mostrarResumen();
    }
}