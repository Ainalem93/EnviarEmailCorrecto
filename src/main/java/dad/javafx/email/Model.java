package dad.javafx.email;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	//generamos las properties para obtener los datos de los textField
	private StringProperty servidor = new SimpleStringProperty();
	private StringProperty remitente = new SimpleStringProperty();
	private StringProperty remitentePass = new SimpleStringProperty();
	private StringProperty destinatario = new SimpleStringProperty();
	private StringProperty asunto = new SimpleStringProperty();
	private StringProperty puerto = new SimpleStringProperty();
	private StringProperty mensaje = new SimpleStringProperty();
	private BooleanProperty ssl = new SimpleBooleanProperty();
	
	public final StringProperty servidorProperty() {
		return this.servidor;
	}
	
	public final String getServidor() {
		return this.servidorProperty().get();
	}
	
	public final void setServidor(final String servidor) {
		this.servidorProperty().set(servidor);
	}
	
	public final StringProperty remitenteProperty() {
		return this.remitente;
	}
	
	public final String getRemitente() {
		return this.remitenteProperty().get();
	}
	
	public final void setRemitente(final String remitente) {
		this.remitenteProperty().set(remitente);
	}
	
	public final StringProperty remitentePassProperty() {
		return this.remitentePass;
	}
	
	public final String getRemitentePass() {
		return this.remitentePassProperty().get();
	}
	
	public final void setRemitentePass(final String remitentePass) {
		this.remitentePassProperty().set(remitentePass);
	}
	
	public final StringProperty destinatarioProperty() {
		return this.destinatario;
	}
	
	public final String getDestinatario() {
		return this.destinatarioProperty().get();
	}
	
	public final void setDestinatario(final String destinatario) {
		this.destinatarioProperty().set(destinatario);
	}
	
	public final StringProperty asuntoProperty() {
		return this.asunto;
	}
	
	public final String getAsunto() {
		return this.asuntoProperty().get();
	}
	
	public final void setAsunto(final String asunto) {
		this.asuntoProperty().set(asunto);
	}
	
	public final StringProperty puertoProperty() {
		return this.puerto;
	}
	
	public final String getPuerto() {
		return this.puertoProperty().get();
	}
	
	public final void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}

	public final StringProperty mensajeProperty() {
		return this.mensaje;
	}
	

	public final String getMensaje() {
		return this.mensajeProperty().get();
	}
	

	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}

	public final BooleanProperty sslProperty() { //informacion del checkbox
		return this.ssl;
	}
	

	public final boolean isSsl() { //informacion del checkbox
		return this.sslProperty().get();
	}
	

	public final void setSsl(final boolean ssl) { //informacion del checkbox
		this.sslProperty().set(ssl);
	}
	
	
	

	
	
}
