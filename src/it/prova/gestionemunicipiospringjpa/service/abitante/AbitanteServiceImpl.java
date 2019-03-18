package it.prova.gestionemunicipiospringjpa.service.abitante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionemunicipiospringjpa.dao.abitante.AbitanteDAO;
import it.prova.gestionemunicipiospringjpa.model.Abitante;

@Component
public class AbitanteServiceImpl implements AbitanteService {

	@Autowired
	private AbitanteDAO abitanteDAO;

	@Transactional(readOnly = true)
	public List<Abitante> listAllAbitanti() {

		return abitanteDAO.list();
	}

	@Transactional(readOnly = true)
	public List<Abitante> listAllAbitantiConMunicipi() {
		return abitanteDAO.listNotLazy();
	}

	@Transactional(readOnly = true)
	public Abitante caricaSingoloAbitante(long id) {
		return abitanteDAO.get(id);
	}

	@Transactional(readOnly = true)
	public Abitante caricaSingoloAbitanteConMunicipio(long id) {
		return abitanteDAO.getNotLazy(id);
	}

	@Transactional
	public void aggiorna(Abitante abitanteInstance) {
		abitanteDAO.update(abitanteInstance);
	}

	@Transactional
	public void inserisciNuovo(Abitante abitanteInstance) {
		abitanteDAO.insert(abitanteInstance);
	}

	@Transactional
	public void rimuovi(Abitante abitanteInstance) {
		abitanteDAO.delete(abitanteInstance);
	}

	@Transactional(readOnly = true)
	public List<Abitante> findByExample(Abitante example) {
		return abitanteDAO.findByExample(example);
	}

	@Override
	public List<Abitante> cercaAbitantiInMunicipio(Long idMunicipio) {
			return abitanteDAO.findAllByMunicipio(idMunicipio);
	}

}
