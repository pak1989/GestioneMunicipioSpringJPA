package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertAbitanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		int eta = Integer.parseInt(request.getParameter("etaInput"));
		String residenza = request.getParameter("residenzaInput");

		Long idMunicipio = Long.parseLong(request.getParameter("municipioInput"));	
		Municipio municipio = municipioService.caricaSingoloMunicipio(idMunicipio);

		Abitante abitanteDaInserire = new Abitante(nome, cognome, eta, residenza);
		abitanteDaInserire.setMunicipio(municipio);
		
		abitanteService.inserisciNuovo(abitanteDaInserire);
		
		RequestDispatcher rd = request.getRequestDispatcher("PrepareSearchAbitanteServlet");
		rd.forward(request, response);
	}

}
