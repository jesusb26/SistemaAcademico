import java.util.ArrayList;
import java.util.List;

public class Foro {
    private String nombre;
    private List<Mensaje> mensajes;

    public Foro(String nombre) {
        this.nombre = nombre;
        this.mensajes = new ArrayList<>();
    }

    // Método para publicar un mensaje en el foro
    public void publicarMensaje(Usuario remitente, String contenido) {
        Mensaje mensaje = new Mensaje(remitente, new ArrayList<>(), nombre, contenido, "FechaActual", "Foro");
        mensajes.add(mensaje);
    }

    // Método para obtener todos los mensajes del foro
    public List<Mensaje> obtenerMensajes() {
        return mensajes;
    }

    // Getter para el nombre del foro
    public String getNombre() {
        return nombre;
    }
}