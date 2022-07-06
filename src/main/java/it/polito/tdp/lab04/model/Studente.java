package it.polito.tdp.lab04.model;

import java.util.Objects;

public class Studente implements Comparable<Studente>{

	private int matricola;
	private String cognome;
	private String nome;
	private String CDS;
	
	public Studente(int matricola, String cognome, String nome, String cDS) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		CDS = cDS;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCDS() {
		return CDS;
	}

	public void setCDS(String cDS) {
		CDS = cDS;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricola);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return matricola == other.matricola;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", cognome=" + cognome + ", nome=" + nome + ", CDS=" + CDS + "]";
	}

	@Override
	public int compareTo(Studente o) {
		if (this.getCognome().compareTo(o.getCognome()) == 0) {
			return this.getNome().compareTo(o.getNome());
		} else {
			return this.getCognome().compareTo(o.getCognome());
		}
	}

	
	
	
	
}
