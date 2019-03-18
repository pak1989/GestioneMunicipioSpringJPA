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

import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;

@WebServlet("/ExecuteSearchAbitanteServlet")
public class ExecuteSearchAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	@Autowired
//	private MunicipioService municipioService;
	
	@Autowired
	private AbitanteService abitanteService;
		
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteSearchAbitanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		Long idMunicipio = Long.parseLong(request.getParameter("municipioInput"));	
		
		if (idMunicipio <= 0) {
			request.setAttribute("listaAbitantiAttributeName", abitanteService.listAllAbitantiConMunicipi());
		} else {
			request.setAttribute("listaAbitantiAttributeName", abitanteService.cercaAbitantiInMunicipio(idMunicipio));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/searchResult.jsp");
		rd.forward(request, response);
	}

}
