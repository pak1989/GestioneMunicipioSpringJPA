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

/**
 * Servlet implementation class ExecuteUpdateServlet
 */
@WebServlet("/ExecuteUpdateServlet")
public class ExecuteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Autowired
	private MunicipioService municipioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
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
		
		
		String descrizioneInput = request.getParameter("descrizioneInput");
		String codiceInput = request.getParameter("codiceInput");
		String ubicazioneInput=request.getParameter("ubicazioneInput");
		String idInput=request.getParameter("idInput");
		int id=0;
		try {
			id=Integer.parseInt(idInput);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

//		Municipio municipioDaModificare = new Municipio(id,descrizioneInput, codiceInput,ubicazioneInput);
		
//		municipioService.aggiorna(municipioDaModificare);
		request.setAttribute("listaMunicipi.attribute.name",municipioService.listAllMunicipi());
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/result.jsp");
		rd.forward(request, response);
		
		
	}

}
