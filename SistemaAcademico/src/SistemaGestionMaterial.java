import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaGestionMaterial {
    private List<RecursoEducativo> recursos; // Lista de recursos educativos
    private List<String> prestamos; // Lista de préstamos (formato: "idRecurso|usuario|fechaPrestamo|fechaDevolucion|estado")
    private List<String> mantenimientos; // Lista de mantenimientos (formato: "idRecurso|fechaInicio|fechaFin|descripcion")

    public SistemaGestionMaterial(List<RecursoEducativo> recursos) {
        this.recursos = recursos;
        this.prestamos = new ArrayList<>();
        this.mantenimientos = new ArrayList<>();
    }

    // Método para realizar un préstamo
    public void realizarPrestamo(String idRecurso, Usuario usuario, Date fechaPrestamo) {
        RecursoEducativo recurso = buscarRecurso(idRecurso);
        if (recurso != null && recurso.getEstado().equals("disponible")) {
            recurso.setEstado("prestado");
            String prestamo = idRecurso + "|" + usuario.getNombre() + "|" + fechaPrestamo.getTime() + "| |activo";
            prestamos.add(prestamo);
            System.out.println("Préstamo realizado: " + recurso.getNombre() + " a " + usuario.getNombre());
        } else {
            System.out.println("El recurso no está disponible para préstamo.");
        }
    }

    // Método para registrar una devolución
    public void registrarDevolucion(String idRecurso, Usuario usuario, Date fechaDevolucion, String estadoRecurso) {
        RecursoEducativo recurso = buscarRecurso(idRecurso);
        if (recurso != null && recurso.getEstado().equals("prestado")) {
            recurso.setEstado("disponible");
            for (int i = 0; i < prestamos.size(); i++) {
                String[] datos = prestamos.get(i).split("\\|");
                if (datos[0].equals(idRecurso) && datos[1].equals(usuario.getNombre()) && datos[4].equals("activo")) {
                    String prestamoActualizado = datos[0] + "|" + datos[1] + "|" + datos[2] + "|" + fechaDevolucion.getTime() + "|devuelto";
                    prestamos.set(i, prestamoActualizado);
                    System.out.println("Devolución registrada: " + recurso.getNombre() + " por " + usuario.getNombre());
                    break;
                }
            }
        } else {
            System.out.println("El recurso no está prestado o no existe.");
        }
    }

    // Método para registrar mantenimiento
    public void registrarMantenimiento(String idRecurso, Date fechaInicio, String descripcion) {
        RecursoEducativo recurso = buscarRecurso(idRecurso);
        if (recurso != null && recurso.getEstado().equals("disponible")) {
            recurso.setEstado("en_mantenimiento");
            String mantenimiento = idRecurso + "|" + fechaInicio.getTime() + "| |" + descripcion;
            mantenimientos.add(mantenimiento);
            System.out.println("Mantenimiento registrado: " + recurso.getNombre());
        } else {
            System.out.println("El recurso no está disponible para mantenimiento.");
        }
    }

    // Método para finalizar mantenimiento
    public void finalizarMantenimiento(String idRecurso, Date fechaFin) {
        RecursoEducativo recurso = buscarRecurso(idRecurso);
        if (recurso != null && recurso.getEstado().equals("en_mantenimiento")) {
            recurso.setEstado("disponible");
            for (int i = 0; i < mantenimientos.size(); i++) {
                String[] datos = mantenimientos.get(i).split("\\|");
                if (datos[0].equals(idRecurso) && datos[2].equals(" ")) {
                    String mantenimientoActualizado = datos[0] + "|" + datos[1] + "|" + fechaFin.getTime() + "|" + datos[3];
                    mantenimientos.set(i, mantenimientoActualizado);
                    System.out.println("Mantenimiento finalizado: " + recurso.getNombre());
                    break;
                }
            }
        } else {
            System.out.println("El recurso no está en mantenimiento o no existe.");
        }
    }

    // Método para buscar un recurso por ID
    private RecursoEducativo buscarRecurso(String idRecurso) {
        for (RecursoEducativo recurso : recursos) {
            if (recurso.getId().equals(idRecurso)) {
                return recurso;
            }
        }
        return null; // Si no se encuentra el recurso
    }

    // Método para listar todos los recursos
    public void listarRecursos() {
        for (RecursoEducativo recurso : recursos) {
            System.out.println("Recurso: " + recurso.getNombre() + ", Estado: " + recurso.getEstado());
        }
    }

    // Método para listar todos los préstamos
    public void listarPrestamos() {
        for (String prestamo : prestamos) {
            String[] datos = prestamo.split("\\|");
            System.out.println("Préstamo: Recurso " + datos[0] + ", Usuario " + datos[1] +
                    ", Fecha préstamo " + new Date(Long.parseLong(datos[2])) +
                    ", Fecha devolución " + (datos[3].equals(" ") ? "No devuelto" : new Date(Long.parseLong(datos[3]))) +
                    ", Estado: " + datos[4]);
        }
    }

    public void verPrestamosDeUsuario(Usuario usuario) {
        System.out.println("Préstamos del usuario: " + usuario.getNombre());
        boolean tienePrestamos = false;
    
        for (String prestamo : prestamos) {
            String[] datos = prestamo.split("\\|");
            if (datos[1].equals(usuario.getNombre())) { // Compara el nombre del usuario
                tienePrestamos = true;
                System.out.println(
                    "Recurso: " + datos[0] +
                    ", Fecha préstamo: " + new Date(Long.parseLong(datos[2])) +
                    ", Fecha devolución: " + (datos[3].equals(" ") ? "No devuelto" : new Date(Long.parseLong(datos[3]))) +
                    ", Estado: " + datos[4]
                );
            }
        }
    
        if (!tienePrestamos) {
            System.out.println("El usuario no tiene préstamos registrados.");
        }
    }

    // Método para listar todos los mantenimientos
    public void listarMantenimientos() {
        for (String mantenimiento : mantenimientos) {
            String[] datos = mantenimiento.split("\\|");
            System.out.println("Mantenimiento: Recurso " + datos[0] +
                    ", Fecha inicio " + new Date(Long.parseLong(datos[1])) +
                    ", Fecha fin " + (datos[2].equals(" ") ? "En progreso" : new Date(Long.parseLong(datos[2]))) +
                    ", Descripción: " + datos[3]);
        }
    }
}