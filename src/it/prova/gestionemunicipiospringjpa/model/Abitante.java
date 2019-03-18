package it.prova.gestionemunicipiospringjpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Abitante implements Serializable {

	private static final long serialVersionUID = -3253059373073442670L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String cognome;
	private int eta;
	private String residenza;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipio_id", nullable = false)
	private Municipio municipio;

	public Abitante() {

	}

	public Abitante(String nome, String cognome, int eta, String residenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
	}

	public Abitante(long id2) {
		// TODO Auto-generated constructor stub
	}

	public Abitante(String nomeInput, String cognomeInput, String residenzaInput, Municipio municipio) {
		// TODO Auto-generated constructor stub
	}

	public Abitante(String nomeInput, String cognomeInput, int eta, String residenzaInput, Municipio municipio) {
		// TODO Auto-generated constructor stub
	}

	public Abitante(long id2, String nomeInput, String cognomeInput, int eta2, String residenzaInput,
			Municipio municipio2) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

}
