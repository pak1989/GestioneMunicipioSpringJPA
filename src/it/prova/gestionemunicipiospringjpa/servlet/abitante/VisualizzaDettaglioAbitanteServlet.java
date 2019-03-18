package it.prova.gestionemunicipiospringjpa.servlet.abitante;

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
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;



@WebServlet("/VisualizzaDettaglioAbitanteServlet")
public class VisualizzaDettaglioAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AbitanteService abitanteService;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public VisualizzaDettaglioAbitanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		
		String idAbitanteDaPagina = request.getParameter("idAbitante");
//		Abitante abitanteTemp=new Abitante();
//		Municipio municipioTemp=new Municipio();
//		abitanteTemp.setMunicipio(municipioTemp);
//		request.setAttribute("abitanteSingolaAttributeName", abitanteService.findByIdEager(Long.parseLong(idAbitanteDaPagina)));
//		request.setAttribute("municipioSingola.attribute.name", municipioService.caricaSingoloMunicipio(abitanteTemp.getMunicipio().getId()));

		
//		request.setAttribute("abitanteSingola.attribute.name", abitanteService.caricaSingoloAbitante(Long.parseLong(idAbitanteDaPagina)));
//		request.setAttribute("municipioSingola.attribute.name", municipioService.caricaSingoloMunicipio(Long.parseLong(idAbitanteDaPagina)));

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/dettaglioAbitante.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
