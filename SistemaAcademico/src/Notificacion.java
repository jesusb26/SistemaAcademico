import java.util.List;
public class Notificacion {
    private EventoAcademico eventoRelacionado;
    private String fechaProgramacion;
    private String canal; // "correo", "sms", "push"
    private boolean enviada;

    public Notificacion(EventoAcademico eventoRelacionado, String fechaProgramacion, String canal) {
        this.eventoRelacionado = eventoRelacionado;
        this.fechaProgramacion = fechaProgramacion;
        this.canal = canal;
        this.enviada = false;
    }

    // Método para programar la notificación
    public boolean programarNotificacion() {
        // Lógica para programar la notificación
        System.out.println("Notificación programada para: " + fechaProgramacion);
        return true;
    }

    // Método para enviar la notificación
    public boolean enviarNotificacion() {
        if (!enviada) {
            Curso curso = eventoRelacionado.getCursoRelacionado();
            List<Estudiante> estudiantes = curso.getEstudiantes();

            switch (canal) {
                case "correo":
                    for (Estudiante estudiante : estudiantes) {
                        System.out.println("Enviando correo a: " + estudiante.getCorreo() +
                                " - Mensaje: " + eventoRelacionado.getDescripcion());
                    }
                    break;
                case "sms":
                    for (Estudiante estudiante : estudiantes) {
                        System.out.println("Enviando SMS a: " + estudiante.getTelefono() +
                                " - Mensaje: " + eventoRelacionado.getDescripcion());
                    }
                    break;
                case "push":
                    System.out.println("Enviando notificación push a los estudiantes del curso: " + curso.getNombre());
                    break;
                default:
                    System.out.println("Canal no válido: " + canal);
                    return false;
            }
            enviada = true;
            return true;
        } else {
            System.out.println("La notificación ya fue enviada.");
            return false;
        }
    }


    // Método para verificar si la notificación fue enviada
    public boolean verificarEnvio() {
        return enviada;
    }

    public EventoAcademico getEventoRelacionado() {
        return eventoRelacionado;
    }

    public void setEventoRelacionado(EventoAcademico eventoRelacionado) {
        this.eventoRelacionado = eventoRelacionado;
    }

    public String getFechaProgramacion() {
        return fechaProgramacion;
    }

    public void setFechaProgramacion(String fechaProgramacion) {
        this.fechaProgramacion = fechaProgramacion;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public boolean isEnviada() {
        return enviada;
    }

    public void setEnviada(boolean enviada) {
        this.enviada = enviada;
    }

}