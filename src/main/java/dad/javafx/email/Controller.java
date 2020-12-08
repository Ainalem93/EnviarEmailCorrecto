package dad.javafx.email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller implements Initializable{

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EnviarEmail.fxml")); //enlace al fxml donde esta la vista
		loader.setController(this);
		loader.load();
		
		enviarBoton.setOnAction(e -> { //prueba de los errores
			try {
				onEnviarAction(e);
			} catch (EmailException e1) {
				e1.printStackTrace();
			}
		});
		
		vaciarBoton.setOnAction(e -> onVaciarAction(e)); //uso del vaciar
		
		cerrarBoton.setOnAction(e -> onCerrarAction(e)); //uso del cerrar

	}
	Model model = new Model();

	@FXML
	private GridPane view;

	@FXML
	private Label servidorLabel;

	@FXML
	private Label conexionLabel;

	@FXML
	private Label remitenteLabel;

	@FXML
	private Label destinatarioLabel;

	@FXML
	private Label asuntoLabel;

	@FXML
	private TextField servidorText;

	@FXML
	private TextField usarConeText;

	@FXML
	private TextField emailText;

	@FXML
	private TextArea mensajeArea;

	@FXML
	private TextField passwordText;

	@FXML
	private TextField emailDesText;

	@FXML
	private TextField asuntoText;

	@FXML
	private VBox botonera;

	@FXML
	private Button enviarBoton;

	@FXML
	private Button vaciarBoton;

	@FXML
	private Button cerrarBoton;

	@FXML
	private CheckBox checkBox;

	
	@FXML
	void onEnviarAction(ActionEvent event) throws EmailException {
		
		Alert bien = new Alert(AlertType.CONFIRMATION);
		Alert error = new Alert(AlertType.ERROR);
		
		try {
			Email email = new SimpleEmail();  //libreria y sus funciones copiadas del ejemplo "A simple text email"
			email.setHostName(model.getServidor()); 
			email.setSslSmtpPort(model.getPuerto());
			email.setAuthenticator(new DefaultAuthenticator(model.getRemitente(), model.getRemitentePass()));
			email.setSSLOnConnect(model.isSsl());
			email.setFrom(model.getRemitente());
			email.setSubject(model.getAsunto());
			email.setMsg(model.getMensaje());
			email.addTo(model.getDestinatario());
			email.send();
			
			bien.setTitle("Mensaje enviado");  //ventana de aviso
			bien.setContentText("Mensaje enviado con éxito a" + "\'" +  model.getDestinatario() + "\'.");
			bien.showAndWait();
			
			model.setDestinatario(""); //dejamos esos textField vacios
			model.setAsunto("");
			model.setMensaje("");
		} catch (EmailException e) {
			error.setTitle("Error"); //ventana de error al no poder enviar el email
			error.setContentText("No se pudo enviar el email");
			error.setHeaderText(e.getMessage());
			error.showAndWait();
		}
	}
	
	@FXML
	void onCerrarAction(ActionEvent event) {  // event para cerrar ventana despues de accionar el boton
		Stage stage = (Stage) view.getScene().getWindow();
		stage.close();
	}

	

	@FXML
	void onVaciarAction(ActionEvent event) { //event para vaciar los campos despues de accionar el boton
		servidorText.clear();
		checkBox.setSelected(false);  //al ser un boton de si o no lo accionamos a false
		usarConeText.textProperty().set("");
		emailText.textProperty().set("");
		passwordText.textProperty().set("");
		emailDesText.textProperty().set("");
		asuntoText.textProperty().set("");
		mensajeArea.textProperty().set("");

		
	}

	public GridPane getView() {  //visualizamos la vista del fmxl
		return view;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.servidorProperty().bind(servidorText.textProperty());
		model.puertoProperty().bind(usarConeText.textProperty());
		model.sslProperty().bind(checkBox.selectedProperty());
		model.remitenteProperty().bind(emailText.textProperty());
		model.remitentePassProperty().bind(passwordText.textProperty());
		model.destinatarioProperty().bind(emailDesText.textProperty());
		model.asuntoProperty().bind(asuntoText.textProperty());
		model.mensajeProperty().bind(mensajeArea.textProperty());
		
	}
	
	
}
