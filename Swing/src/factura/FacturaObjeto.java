package factura;

import java.time.LocalDate;

public class FacturaObjeto {
	private String asunto,cantidad,tipo;
	private LocalDate fecha;
	public FacturaObjeto(String asunto, String cantidad, String tipo, LocalDate fecha) {
		super();
		this.asunto = asunto;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.fecha = fecha;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "FacturaObjeto [asunto=" + asunto + ", cantidad=" + cantidad + ", tipo=" + tipo + ", fecha=" + fecha
				+ "]";
	}
	
	
	
	
}
