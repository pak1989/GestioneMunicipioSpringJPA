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

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteFindAbitantiServlet
 */
@WebServlet("/ExecuteFindAbitantiServlet")
public class ExecuteFindAbitantiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteFindAbitantiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String etaInput = request.getParameter("etaInput");
		String residenzaInput = request.getParameter("residenzaInput");
		String municipioIdInput = request.getParameter("municipioIdInput");
		long municipioId=0;
		
		Municipio municipio=new Municipio() ;
		try {
			municipioId=Long.parseLong(municipioIdInput);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		municipio.setId(municipioId);
		Abitante abitante=new Abitante(nomeInput, cognomeInput, residenzaInput,municipio);
//		request.setAttribute("listaMunicipi.attribute.name",abitanteService.findByExample(abitante,etaInput));

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
		rd.forward(request, response);
	}

}
