package it.prova.gestionemunicipiospringjpa.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

@WebServlet("/ExecuteModificaMunicipioServlet")
public class ExecuteModificaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaMunicipioServlet() {
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

		long idMunicipio = Long.parseLong(request.getParameter("idInput"));		
		
		Municipio municipioDaModificare = municipioService.caricaSingoloMunicipio(idMunicipio);
		
		String descrizione = request.getParameter("descrizioneInput");
		String codice = request.getParameter("codiceInput");
		String ubicazione = request.getParameter("ubicazioneInput");

		municipioDaModificare.setDescrizione(descrizione);
		municipioDaModificare.setCodice(codice);
		municipioDaModificare.setUbicazione(ubicazione);

		municipioService.aggiorna(municipioDaModificare);

		request.setAttribute("municipioAttributeName", municipioDaModificare);

		RequestDispatcher rd = request.getRequestDispatcher("/municipio/dettaglio.jsp");
		rd.forward(request, response);
	}

}
