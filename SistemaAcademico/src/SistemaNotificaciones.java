import java.util.ArrayList;
import java.util.List;

public class SistemaNotificaciones {
    private List<Notificacion> notificaciones;

    public SistemaNotificaciones() {
        this.notificaciones = new ArrayList<>();
    }

    // Método para crear una notificación de evento académico
    public void crearNotificacionEvento(EventoAcademico evento, String canal) {
        String fechaProgramacion = evento.getFechaInicio(); // Notificar el día del evento
        Notificacion notificacion = new Notificacion(evento, fechaProgramacion, canal);
        notificacion.programarNotificacion();
        agregarNotificacion(notificacion);
    }

    // Método para crear una notificación de entrega de tarea
    public void crearNotificacionEntregaTarea(EntregaTarea entrega, String canal) {
        String mensaje = "El estudiante " + entrega.getEstudiante().getNombre() +
                " ha entregado la tarea '" + entrega.getTarea().getNombre() + "'.";
        EventoAcademico evento = new EventoAcademico("entrega_tarea", entrega.getFechaEntrega(), entrega.getFechaEntrega(), 0, mensaje, entrega.getTarea().getCurso());
        Notificacion notificacion = new Notificacion(evento, entrega.getFechaEntrega(), canal);
        notificacion.programarNotificacion();
        agregarNotificacion(notificacion);
    }

    // Método para agregar una notificación al sistema
    private void agregarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }

    // Método para enviar todas las notificaciones pendientes
    public void enviarNotificacionesPendientes() {
        for (Notificacion notificacion : notificaciones) {
            if (!notificacion.verificarEnvio()) {
                notificacion.enviarNotificacion();
            }
        }
    }

    // Método para listar todas las notificaciones
    public void listarNotificaciones() {
        for (Notificacion notificacion : notificaciones) {
            System.out.println("Notificación para: " + notificacion.getEventoRelacionado().getDescripcion() +
                    ", Canal: " + notificacion.getCanal() +
                    ", Enviada: " + notificacion.verificarEnvio());
        }
    }

    
}