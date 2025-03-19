public class SistemaReporte {

    // Método para generar un reporte de asistencia de un estudiante
    public void generarReporteAsistencia(Estudiante estudiante) {
        
    }

    // Método para generar un reporte de calificaciones de un estudiante
    public void generarReporteCalificaciones(Estudiante estudiante) {
        
    }

    // Método para generar un reporte de reservas o préstamos de un estudiante
    public void generarReporteReservasPrestamos(Estudiante estudiante, SistemaGestionMaterial sistemaGestionMaterial) {
        
    }

    // Método para generar un reporte completo de un estudiante
    public void generarReporteCompleto(Estudiante estudiante, SistemaGestionMaterial sistemaGestionMaterial) {
        generarReporteAsistencia(estudiante);
        generarReporteCalificaciones(estudiante);
        generarReporteReservasPrestamos(estudiante, sistemaGestionMaterial);
    }
}