import java.util.ArrayList;
import java.util.List;

public class SistemaReserva {
    private List<EspacioAcademico> espaciosAcademicos; 
    private List<ReservaEspacio> reservas; 

    public SistemaReserva() {
        this.espaciosAcademicos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Método para agregar un espacio académico al sistema
    public void agregarEspacioAcademico(EspacioAcademico espacio) {
        espaciosAcademicos.add(espacio);
    }

    // Método para buscar un espacio académico por nombre
    public EspacioAcademico buscarEspacioAcademico(String nombre) {
        for (EspacioAcademico espacio : espaciosAcademicos) {
            if (espacio.getNombre().equals(nombre)) {
                return espacio;
            }
        }
        return null; // Si no se encuentra el espacio
    }

    // Método para crear una reserva
    public void crearReserva(EspacioAcademico espacio, Usuario usuario, String fecha, String horaInicio, String horaFin) {
        
    }

    // Método para cancelar una reserva
    public void cancelarReserva(ReservaEspacio reserva) {
        reserva.cancelarReserva();
        reservas.remove(reserva);
    }

    // Método para verificar si un usuario tiene reservas superpuestas
    private boolean tieneReservaSuperpuesta(Usuario usuario, String fecha, String horaInicio, String horaFin) {
        return false;
    }

    // Método para listar todas las reservas
    public void listarReservas() {
        
    }

    public List<EspacioAcademico> getEspaciosAcademicos() {
        return espaciosAcademicos;
    }

    public List<ReservaEspacio> getReservas() {
        return reservas;
    }
}