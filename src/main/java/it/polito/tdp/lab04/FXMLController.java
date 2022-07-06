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

    @FXML
    void doCercaStudente(ActionEvent event) {
    	
    	txtNome.clear();
    	txtCognome.clear();
    	lblErrore.setText("");
    	
    	String studente = txtMatricola.getText();
    	int matricola;
    	
    	try {
    		matricola = Integer.parseInt(studente);
    	} catch (NumberFormatException e) {
    		lblErrore.setText("La matricola deve essere un numero!");
    		return;
    	}
    	
    	if (matricola < 0) {
    		lblErrore.setText("La matricola deve essere un numero positivo!");
    		return;
    	}
    	
    	Studente s;
    	
    	try {
    		s = this.model.getStudenteByMatricola(matricola);
    	} catch (RuntimeException e) {
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
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {

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
    	cmbCorso.getItems().add("");
    }
}