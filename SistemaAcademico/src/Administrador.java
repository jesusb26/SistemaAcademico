
public class Administrador extends Usuario {
    private Docente docente;

    // Constructor para un administrador que no es docente
    public Administrador(String nombre, String email, String telefono, int edad, Rol rol) {
        super(nombre, email, telefono, edad); 
        this.docente = null; 
        this.asignarRol(rol); 
    }

    // Constructor para un administrador que también es docente
    public Administrador(Docente docente, Rol rol) {
        super(docente.getNombre(), docente.getEmail(), docente.getTelefono(), docente.getEdad()); // Llama al constructor de Usuario con los datos del docente
        this.docente = docente;
        this.asignarRol(rol); // Asigna el rol al administrador
    }

    public void gestionarEspacios(EspacioAcademico espacio, String accion) {
       
    }

    
    public void aprobarReserva(ReservaEspacio reserva) {
        
    }

    
    public void gestionarUsuarios(Usuario usuario, String accion) {
        
    }

    
    public void generarReportes(String tipoReporte) {
        
    }

    
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}