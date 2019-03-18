package it.prova.gestionemunicipiospringjpa.service.abitante;

import java.util.List;

import it.prova.gestionemunicipiospringjpa.model.Abitante;

public interface AbitanteService {
	
	public List<Abitante> listAllAbitanti();

	public List<Abitante> listAllAbitantiConMunicipi();

	public Abitante caricaSingoloAbitante(long id);

	public Abitante caricaSingoloAbitanteConMunicipio(long id);

	public void aggiorna(Abitante abitanteInstance);

	public void inserisciNuovo(Abitante abitanteInstance);

	public void rimuovi(Abitante abitanteInstance);

	public List<Abitante> findByExample(Abitante example);
	
	public List<Abitante> cercaAbitantiInMunicipio(Long idMunicipio);
	
}
