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

@WebServlet("/ExecuteInsertMunicipioServlet")
public class ExecuteInsertMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertMunicipioServlet() {
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

		String descrizione = request.getParameter("descrizioneInput");
		String codice = request.getParameter("codiceInput");
		String ubicazione = request.getParameter("ubicazioneInput");

		Municipio municipioDainserie = new Municipio(descrizione, codice, ubicazione);

		municipioService.inserisciNuovo(municipioDainserie);

		request.setAttribute("municipioAttributeName", municipioDainserie);

		RequestDispatcher rd = request.getRequestDispatcher("SearchMunicipioServlet");
		rd.forward(request, response);
	}

}
