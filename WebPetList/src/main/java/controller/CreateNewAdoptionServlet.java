package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adopted;
import model.AdoptionDetails;
import model.PetList;

/**
 * Servlet implementation class CreateNewAdoptionServlet
 */
@WebServlet("/createNewAdoptionServlet")
public class CreateNewAdoptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAdoptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PetListHelper plh = new PetListHelper();
		String adoptionList = request.getParameter("adoptionList");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String adoptedBy = request.getParameter("adoptedBy");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedPet = request.getParameterValues("allPetsToAdd");
		List<PetList> selectedPetInAdoption = new ArrayList<PetList>();
		
		if(selectedPet != null && selectedPet.length > 0){
			for(int i = 0; i<selectedPet.length; i++) {
				PetList c = plh.searchForPetById(Integer.parseInt(selectedPet[i]));
				selectedPetInAdoption.add(c);
			}
		}
		
		Adopted adoptedPet = new Adopted(adoptedBy);
		
		AdoptionDetails ad = new AdoptionDetails(adoptionList, ld, adoptedPet);
		
		ad.setListOfPets(selectedPetInAdoption);
		
		AdoptionDetailsHelper adh = new AdoptionDetailsHelper();
		adh.insertNewAdoptionDetails(ad);
		
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
