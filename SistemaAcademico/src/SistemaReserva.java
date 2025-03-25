import java.util.ArrayList;
import java.util.List;

public class SistemaReserva {
    private List<EspacioAcademico> espaciosAcademicos; // Lista de espacios académicos
    private List<ReservaEspacio> reservas; // Lista de reservas

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
        if (espacio.verificarDisponibilidad() && !tieneReservaSuperpuesta(usuario, fecha, horaInicio, horaFin)) {
            ReservaEspacio reserva = new ReservaEspacio(espacio, usuario, fecha, horaInicio, horaFin);
            reserva.reportarReserva();
            reservas.add(reserva);
        } else {
            System.out.println("No se pudo crear la reserva. Espacio no disponible o reserva superpuesta.");
        }
    }

    // Método para cancelar una reserva
    public void cancelarReserva(ReservaEspacio reserva) {
        reserva.cancelarReserva();
        reservas.remove(reserva);
    }

    // Método para verificar si un usuario tiene reservas superpuestas
    private boolean tieneReservaSuperpuesta(Usuario usuario, String fecha, String horaInicio, String horaFin) {
        for (ReservaEspacio reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                if (reserva.getFecha().equals(fecha)) {
                    if (!(horaFin.compareTo(reserva.getHoraInicio()) <= 0 || horaInicio.compareTo(reserva.getHoraFin()) >= 0)) {
                        return true; // Hay superposición de horarios
                    }
                }
            }
        }
        return false; // No hay superposición
    }

    // Método para listar todas las reservas
    public void listarReservas() {
        for (ReservaEspacio reserva : reservas) {
            System.out.println("Reserva para " + reserva.getUsuario().getNombre() +
                    " en " + reserva.getEspacio().getNombre() +
                    " el " + reserva.getFecha() +
                    " de " + reserva.getHoraInicio() + " a " + reserva.getHoraFin());
        }
    }

    public List<EspacioAcademico> getEspaciosAcademicos() {
        return espaciosAcademicos;
    }

    public List<ReservaEspacio> getReservas() {
        return reservas;
    }
}