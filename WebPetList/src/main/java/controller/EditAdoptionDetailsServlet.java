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
 * Servlet implementation class EditAdoptionDetailsServlet
 */
@WebServlet("/editAdoptionDetailsServlet")
public class EditAdoptionDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdoptionDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdoptionDetailsHelper dao = new AdoptionDetailsHelper();
		PetListHelper plh = new PetListHelper();
		AdoptedHelper ah = new AdoptedHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		AdoptionDetails adoptionToUpdate = dao.searchForAdoptionDetailsById(tempId);

		String adoptionList = request.getParameter("adoptionList");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String adoptedBy = request.getParameter("adoptedBy");
		Adopted newAdoption = ah.findAdopted(adoptedBy);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<PetList> selectedItemsInList = new ArrayList<PetList>();

			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				PetList c = plh.searchForPetById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}
			adoptionToUpdate.setListOfPets(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<PetList> selectedItemsInList = new ArrayList<PetList>();
			adoptionToUpdate.setListOfPets(selectedItemsInList);
		}

		adoptionToUpdate.setAdoptionList(adoptionList);
		adoptionToUpdate.setAdoptedDate(ld);
		adoptionToUpdate.setAdoptedBy(newAdoption);

		dao.updateAdoption(adoptionToUpdate);

		getServletContext().getRequestDispatcher("/viewAllAdoptionsServlet").forward(request, response);
	}

	}
