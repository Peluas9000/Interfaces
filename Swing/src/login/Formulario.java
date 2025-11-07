package login;

public class Formulario {
	private String usuario;
	private String contrasenia;
	public Formulario(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		return "Formulario [usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}
	
	
}
