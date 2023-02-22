package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdoptionDetails;

/**
 * Servlet implementation class AdoptionNavigationServlet
 */
@WebServlet("/adoptionNavigationServlet")
public class AdoptionNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdoptionNavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdoptionDetailsHelper dao = new AdoptionDetailsHelper();
		String act = request.getParameter("doThisToPet");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AdoptionDetails adoptionToDelete = dao.searchForAdoptionDetailsById(tempId);
				dao.deleteAdoption(adoptionToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AdoptionDetails adoptionToEdit = dao.searchForAdoptionDetailsById(tempId);
				request.setAttribute("adoptionToEdit", adoptionToEdit);
				request.setAttribute("month", adoptionToEdit.getAdoptedDate().getMonthValue());
				request.setAttribute("date", adoptionToEdit.getAdoptedDate().getDayOfMonth());
				request.setAttribute("year", adoptionToEdit.getAdoptedDate().getYear());
				AdoptedHelper daoForAdoptions = new AdoptedHelper();

				request.setAttribute("allAdoptions", daoForAdoptions.showAllAdopted());

				if (daoForAdoptions.showAllAdopted().isEmpty()) {
					request.setAttribute("allAdoptions", " ");
				}
				getServletContext().getRequestDispatcher("/edit-adoption.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllAdoptionsServlet").forward(request, response);
			}

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-adoption.html").forward(request, response);
		}

	}

}
