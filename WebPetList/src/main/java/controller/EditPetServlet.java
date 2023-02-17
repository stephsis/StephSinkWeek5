package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetList;

/**
 * Servlet implementation class EditPetServlet
 */
@WebServlet("/editPetServlet")
public class EditPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PetListHelper dao = new PetListHelper();
		
		String animal = request.getParameter("animal");
		String breed = request.getParameter("breed");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		PetList petToUpdate = dao.searchForPetById(tempId);
		petToUpdate.setAnimal(animal);
		petToUpdate.setBreed(breed);
		dao.updatePet(petToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	}

}
