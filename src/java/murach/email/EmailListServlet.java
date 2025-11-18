package murach.email;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import murach.business.User;
import murach.data.UserDB;
@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // default action
        }

        // perform action and set URL
        if (action.equals("join")) {
            url = "/index.html";   // trang form
        }
        else if (action.equals("add")) {
    // get data from form
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String dob = request.getParameter("dob");
    String hear = request.getParameter("hear");
    String receiveCDs = request.getParameter("receive_cds");
    String receiveEmails = request.getParameter("receive_email");
    String contactMethod = request.getParameter("contact_method");

    // create User object
    User user = new User();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setEmail(email);
    user.setDob(dob);
    user.setHear(hear);
    user.setReceiveCDs(receiveCDs != null ? "Yes" : "No");
    user.setReceiveEmails(receiveEmails != null ? "Yes" : "No");
    user.setContactMethod(contactMethod);

    // save to DB (optional, nếu không cần thì bỏ)
    UserDB.insert(user);

    // store user in request to display on thanks page
    request.setAttribute("user", user);

    // chuyển sang trang cảm ơn
    url = "/thanks.jsp";
}


        // forward to page
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}
