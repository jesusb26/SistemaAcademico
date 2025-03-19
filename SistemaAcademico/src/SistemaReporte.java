public class SistemaReporte {

    // Método para generar un reporte de asistencia de un estudiante
    public void generarReporteAsistencia(Estudiante estudiante) {
        System.out.println("Reporte de Asistencia para: " + estudiante.getNombre());
        List<Asistencia> asistencias = estudiante.getAsistencias();
        if (asistencias.isEmpty()) {
            System.out.println("No hay registros de asistencia.");
        } else {
            for (Asistencia asistencia : asistencias) {
                System.out.println(asistencia);
            }
        }
        System.out.println("----------------------------------------");
    }

    // Método para generar un reporte de calificaciones de un estudiante
    public void generarReporteCalificaciones(Estudiante estudiante) {
        System.out.println("Reporte de Calificaciones para: " + estudiante.getNombre());
        List<Calificacion> calificaciones = estudiante.getCalificaciones();
        if (calificaciones.isEmpty()) {
            System.out.println("No hay registros de calificaciones.");
        } else {
            for (Calificacion calificacion : calificaciones) {
                System.out.println(calificacion);
            }
        }
        System.out.println("----------------------------------------");
    }

    // Método para generar un reporte de reservas o préstamos de un estudiante
    public void generarReporteReservasPrestamos(Estudiante estudiante, SistemaGestionMaterial sistemaGestionMaterial) {
        System.out.println("Reporte de Reservas y Préstamos para: " + estudiante.getNombre());
        System.out.println("Reservas de espacios académicos:");
        sistemaGestionMaterial.listarPrestamosDeUsuario(estudiante);
        System.out.println("----------------------------------------");
    }

    // Método para generar un reporte completo de un estudiante
    public void generarReporteCompleto(Estudiante estudiante, SistemaGestionMaterial sistemaGestionMaterial) {
        System.out.println("Reporte Completo para: " + estudiante.getNombre());
        generarReporteAsistencia(estudiante);
        generarReporteCalificaciones(estudiante);
        generarReporteReservasPrestamos(estudiante, sistemaGestionMaterial);
    }
}