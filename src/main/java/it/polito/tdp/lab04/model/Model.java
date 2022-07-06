package it.polito.tdp.lab04.model;

import java.sql.SQLException;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	
	public Model() {
		corsoDAO = new CorsoDAO();
		studenteDAO = new StudenteDAO();
	}

	public List<Corso> getTuttiICorsi() {
		try {
			return corsoDAO.getTuttiICorsi();
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	
	public Studente getStudenteByMatricola(int matricola) {
		try {
			Studente s = studenteDAO.getStudenteByMatricola(matricola);
			return s;
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	
	public Corso getCorsoByCodice(String codins) {
		try {
			Corso c = corsoDAO.getCorsoByCodice(codins);
			return c;
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		try {
			List<Studente> studenti = corsoDAO.getStudentiIscrittiAlCorso(corso);
			return studenti;
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public List<Corso> getCorsiByIscritto(Studente studente) {
		try {
			List<Corso> corsi = studenteDAO.getCorsiByIscritto(studente);
			return corsi;
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	
}
