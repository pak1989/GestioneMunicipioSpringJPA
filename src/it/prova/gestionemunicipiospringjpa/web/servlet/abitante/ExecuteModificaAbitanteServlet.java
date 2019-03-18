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

@WebServlet("/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
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

	public ExecuteModificaAbitanteServlet() {
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

		Long idAbitante = Long.parseLong(request.getParameter("idInput"));	
		Abitante abitanteDaModificare = abitanteService.caricaSingoloAbitante(idAbitante);

		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		int eta = Integer.parseInt(request.getParameter("etaInput"));
		String residenza = request.getParameter("residenzaInput");

		Long idMunicipio = Long.parseLong(request.getParameter("municipioInput"));	
		Municipio municipio = municipioService.caricaSingoloMunicipio(idMunicipio);

		
		abitanteDaModificare.setNome(nome);
		abitanteDaModificare.setCognome(cognome);
		abitanteDaModificare.setEta(eta);
		abitanteDaModificare.setResidenza(residenza);
		abitanteDaModificare.setMunicipio(municipio);
		
		abitanteService.aggiorna(abitanteDaModificare);
		
		request.setAttribute("abitanteAttributeName", abitanteDaModificare);
		
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/dettaglio.jsp");
		rd.forward(request, response);
	}

}
