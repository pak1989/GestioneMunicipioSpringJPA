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

@WebServlet("/ExecuteEliminaMunicipioServlet")
public class ExecuteEliminaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteEliminaMunicipioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		String codice = request.getParameter("codiceInput");
		long idMunicipio = Long.parseLong(request.getParameter("idInput"));

		String destinazione = null;
		
		Municipio municipioDaEliminare = municipioService.caricaSingoloMunicipio(idMunicipio);
		
		if (!codice.equals(municipioDaEliminare.getCodice())) {
			String messaggioDaInviareAPagina = "Attenzione! Codice Sbagliato.";
			request.setAttribute("municipio.attribute.name", municipioDaEliminare);
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			destinazione = "/municipio/eliminaForm.jsp";
		} else {
		
		municipioService.rimuovi(municipioDaEliminare);
		destinazione = "SearchMunicipioServlet";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
