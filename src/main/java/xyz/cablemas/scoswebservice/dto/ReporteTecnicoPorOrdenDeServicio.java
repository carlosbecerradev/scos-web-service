package xyz.cablemas.scoswebservice.dto;

public interface ReporteTecnicoPorOrdenDeServicio {
	Long getOrdenId();
	String getTecnico();
	String getNroDeCarnet();
	String getCliente();
	String getTipoDeIncidencia();
	String getFechaDeCreacion();
	Short getDuracionDeEspera();
	Short getDuracionDeRecorrido();
	Short getDuracionDeResolucion();
	Short getDuracionDeEncuesta();
	String getValoracion();
	String getEstado();
}
