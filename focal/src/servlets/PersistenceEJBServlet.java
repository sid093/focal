package servlets;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.persistence.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sap.security.core.server.csi.IXSSEncoder;
import com.sap.security.core.server.csi.XSSEncoder;

import beans.UserBean;
/**
 * Servlet implementation class PersistenceEJBServlet
 */
@WebServlet("/")
public class PersistenceEJBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	UserBean userBean;
	/** {@inheritDoc} */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<p>Persistence with JPA!</p>");
		try {
			appendUserTable(response);
			appendAddForm(response);
		} catch (Exception e) {
			response.getWriter().println(
					"Persistence operation failed with reason: "
							+ e.getMessage());
		}
	}
	/** {@inheritDoc} */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doAdd(request);
			doGet(request, response);
		} catch (Exception e) {
			response.getWriter().println(
					"Persistence operation failed with reason: "
							+ e.getMessage());
		}
	}
	private void appendUserTable(HttpServletResponse response)
			throws SQLException, IOException {
		// Append table that lists all persons
		List<User> resultList = userBean.getAllUsers();
		response.getWriter().println(
				"<p><table border=\"1\"><tr><th colspan=\"3\">"
						+ (resultList.isEmpty() ? "" : resultList.size()
								+ " ")
						+ "Entries in the Database</th></tr>");
		if (resultList.isEmpty()) {
			response.getWriter().println(
					"<tr><td colspan=\"3\">Database is empty</td></tr>");
		} else {
			response.getWriter()
			.println(
					"<tr><th>First name</th><th>Last name</th><th>Id</th></tr>");
		}
		IXSSEncoder xssEncoder = XSSEncoder.getInstance();
		for (User u : resultList) {
			response.getWriter().println(
					"<tr><td>" + xssEncoder.encodeHTML(Long.toString(u.getId()))
					+ "</td><td>"
					+ xssEncoder.encodeHTML(u.getName())
					+ "</td><td>" + xssEncoder.encodeHTML(u.getPassword())
					+ "</td></tr>");
		}
		response.getWriter().println("</table></p>");
	}
	private void appendAddForm(HttpServletResponse response) throws IOException {
		// Append form through which new persons can be added
		response.getWriter()
		.println(
				"<p><form action=\"\" method=\"post\">"
						+ "Name:<input type=\"text\" name=\"name\">"
						+ "&nbsp;Password:<input type=\"text\" name=\"password\">"
						+ "&nbsp;<input type=\"submit\" value=\"Add User\">"
						+ "</form></p>");
	}
	private void doAdd(HttpServletRequest request) throws ServletException,
	IOException, SQLException {
		// Extract name of person to be added from request
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (name != null && password != null
				&& !name.trim().isEmpty()
				&& !password.trim().isEmpty()) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			userBean.addUser(user);
		}
	}
}