package pojo;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Contacto {
	private int idContacto;
	private String Nombre;
	private String Apellido;
	private Date FechaNacimiento;
	private String Genero;
	private String TelefonoPrincipal;
	private String TelefonoAuxiliar;
	private String Direccion;
	private Date FechaCreacion;
	private Date FechaModificacion;
	private int Activo;
	
	public int getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public String getTelefonoPrincipal() {
		return TelefonoPrincipal;
	}
	public void setTelefonoPrincipal(String telefonoPrincipal) {
		TelefonoPrincipal = telefonoPrincipal;
	}
	public String getTelefonoAuxiliar() {
		return TelefonoAuxiliar;
	}
	public void setTelefonoAuxiliar(String telefonoAuxiliar) {
		TelefonoAuxiliar = telefonoAuxiliar;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public Date getFechaCreacion() {
		return FechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return FechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		FechaModificacion = fechaModificacion;
	}
	public int getActivo() {
		return Activo;
	}
	public void setActivo(int Activo) {
		this.Activo = Activo;
	}
	
}
