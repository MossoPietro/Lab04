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
	
	
	

}
