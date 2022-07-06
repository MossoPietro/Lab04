/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private Button btnIscrivi;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnRicerca;
    
    @FXML
    private ComboBox<String> cmbCorso;

    @FXML
    private Label lblErrore;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtRisultato;

    private Studente cercaStudente(String codice) {
    	int matricola;
    	
    	try {
    		matricola = Integer.parseInt(codice);
    	} catch (NumberFormatException e) {
    		throw new IllegalArgumentException("La matricola deve essere un numero!", e);
    	}
    	
    	if (matricola < 0) {
    		throw new IllegalArgumentException("La matricola deve essere un numero positivo!");
    	}
    	
    	Studente s;
    	
    	try {
    		s = this.model.getStudenteByMatricola(matricola);
    	} catch (RuntimeException e) {
    		throw new RuntimeException(e.getMessage(), e);
    	}
    	
    	return s;
    }
    
    @FXML
    void doCercaStudente(ActionEvent event) {
    	
    	txtNome.clear();
    	txtCognome.clear();
    	lblErrore.setText("");
    	
    	String studente = txtMatricola.getText();
    	Studente s;
    	
    	try {
    		s = cercaStudente(studente);
    	} catch (Exception e ) {
    		lblErrore.setText(e.getMessage());
    		return;
    	}
    	
    	if (s == null) {
    		lblErrore.setText("Studente non presente");
    		return;
    	}
    	
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	
    }
    

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
    	txtRisultato.clear();
    	lblErrore.setText("");
    	
    	String codins = cmbCorso.getValue();
    	
    	if (codins.equals("Corsi") || codins == null) {
    		lblErrore.setText("Selezionare un corso");
    		return;
    	}
    	
    	Corso corso;
    	
    	try {
    		corso = this.model.getCorsoByCodice(codins);
    	} catch (RuntimeException e) {
    		lblErrore.setText(e.getMessage());
    		return;
    	}
    	
    	if (corso == null) {
    		lblErrore.setText("Il corso selezionato non è presente!");
    		return;
    	}
    	
    	List<Studente> risultato = new ArrayList<Studente>();
    	
    	try {
    		risultato = this.model.getStudentiIscrittiAlCorso(corso);
    	} catch (RuntimeException e) {
    		lblErrore.setText(e.getMessage());
    		return;
    	}
    	
    	if (risultato == null || risultato.size() == 0) {
    		txtRisultato.setText("Il corso selezionato non presenta iscritti");
    		return;
    	}
    	
    	for (Studente s : risultato) {
    		txtRisultato.appendText(s.toString() + "\n");
    	}
    	
    }
    
    @FXML
    void doCercaCorsi(ActionEvent event) {
    	lblErrore.setText("");
    	txtRisultato.clear();
    	
    	String studente = txtMatricola.getText();
    	Studente s;
    	
    	try {
    		s = cercaStudente(studente);
    	} catch (Exception e ) {
    		lblErrore.setText(e.getMessage());
    		return;
    	}
    	
    	if (s == null) {
    		lblErrore.setText("Studente non presente");
    		return;
    	}
    	
    	List<Corso> risultato = new ArrayList<Corso>();
    	
    	try {
    		risultato = this.model.getCorsiByIscritto(s);
    	} catch (RuntimeException e) {
    		lblErrore.setText(e.getMessage());
    		return;
    	}
    	
    	if (risultato == null || risultato.size() == 0) {
    		txtRisultato.setText("Lo studente selezionato non è iscritto ad alcun corso");
    		return;
    	}
    	
    	for (Corso c : risultato) {
    		txtRisultato.appendText(c.toString() + "\n");
    	}
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	cmbCorso.setValue("Corsi");
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtRisultato.clear();
    	lblErrore.setText("");
    }

    @FXML
    void initialize() {
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbCorso != null : "fx:id=\"cmbCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrore != null : "fx:id=\"lblErrore\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
   
    public void setModel(Model model) {
    	this.model = model;
    
    	cmbCorso.setValue("Corsi");
    	List<Corso> corsi = new ArrayList<Corso>();
    	try {
    		corsi = model.getTuttiICorsi();
    	} catch (RuntimeException e) {
    		lblErrore.setText(e.getMessage());
    		return;
    	}
    	for (Corso c : corsi) {
    		cmbCorso.getItems().add(c.getCodins());
    	}
    }
}