package it.prova.gestionemunicipiospringjpa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Municipio implements Serializable {

	private static final long serialVersionUID = 6848359105769176105L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String descrizione;
	private String codice;
	private String ubicazione;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "municipio", orphanRemoval = false)
	private Set<Abitante> abitanti = new HashSet<>();

	public Municipio() {
	}

	public Municipio(String descrizione, String codice, String ubicazione) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
	}

	public Municipio(long municipioId) {
		// TODO Auto-generated constructor stub
	}

	public Set<Abitante> getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(Set<Abitante> abitanti) {
		this.abitanti = abitanti;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

}
