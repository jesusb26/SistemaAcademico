import java.util.List;

public class Administrador extends Usuario {
    private Docente docente; // Relación con un docente (puede ser null si no es docente)

    // Constructor para un administrador que no es docente
    public Administrador(String nombre, String email, String telefono, int edad, Rol rol) {
        super(nombre, email, telefono, edad); // Llama al constructor de Usuario
        this.docente = null; // No es un docente
        this.asignarRol(rol); // Asigna el rol al administrador
    }

    // Constructor para un administrador que también es docente
    public Administrador(Docente docente, Rol rol) {
        super(docente.getNombre(), docente.getEmail(), docente.getTelefono(), docente.getEdad()); // Llama al constructor de Usuario con los datos del docente
        this.docente = docente;
        this.asignarRol(rol); // Asigna el rol al administrador
    }

    // Método para gestionar espacios académicos
    public void gestionarEspacios(EspacioAcademico espacio, String accion) {
        if (this.getRol().tienePermiso("gestionar_espacios")) {
            switch (accion) {
                case "agregar":
                    System.out.println("Espacio académico agregado: " + espacio.getNombre());
                    break;
                case "modificar":
                    System.out.println("Espacio académico modificado: " + espacio.getNombre());
                    break;
                case "eliminar":
                    System.out.println("Espacio académico eliminado: " + espacio.getNombre());
                    break;
                default:
                    System.out.println("Acción no válida.");
            }
        } else {
            System.out.println("No tienes permisos para gestionar espacios.");
        }
    }

    // Método para aprobar una reserva
    public void aprobarReserva(ReservaEspacio reserva) {
        if (this.getRol().tienePermiso("aprobar_reservas")) {
            reserva.reportarReserva();
            System.out.println("Reserva aprobada para " + reserva.getUsuario().getNombre());
        } else {
            System.out.println("No tienes permisos para aprobar reservas.");
        }
    }

    // Método para gestionar usuarios
    public void gestionarUsuarios(Usuario usuario, String accion) {
        if (this.getRol().tienePermiso("gestionar_usuarios")) {
            switch (accion) {
                case "agregar":
                    System.out.println("Usuario agregado: " + usuario.getNombre());
                    break;
                case "modificar":
                    System.out.println("Usuario modificado: " + usuario.getNombre());
                    break;
                case "eliminar":
                    System.out.println("Usuario eliminado: " + usuario.getNombre());
                    break;
                default:
                    System.out.println("Acción no válida.");
            }
        } else {
            System.out.println("No tienes permisos para gestionar usuarios.");
        }
    }

    // Método para generar reportes
    public void generarReportes(String tipoReporte) {
        if (this.getRol().tienePermiso("generar_reportes")) {
            System.out.println("Generando reporte de tipo: " + tipoReporte);
        } else {
            System.out.println("No tienes permisos para generar reportes.");
        }
    }

    // Getters y setters
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}