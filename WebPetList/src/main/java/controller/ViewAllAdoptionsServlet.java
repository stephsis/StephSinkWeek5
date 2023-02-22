package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdoptionDetails;

/**
 * Servlet implementation class ViewAllAdoptionsServlet
 */
@WebServlet("/viewAllAdoptionsServlet")
public class ViewAllAdoptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllAdoptionsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdoptionDetailsHelper adh = new AdoptionDetailsHelper();
		List<AdoptionDetails> pet = adh.getPets();
		request.setAttribute("allAdoptions", pet);
	
		if(pet.isEmpty()) {
			request.setAttribute("allAdoptions", "");
		}
		
		getServletContext().getRequestDispatcher("/adoption-list-by-pet.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
