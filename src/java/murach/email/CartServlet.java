package murach.email;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import murach.business.*;
import murach.data.ProductIO;
import murach.business.Product;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/products.txt");

        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }

        String url = "/cart.jsp";

        // -----------------------------
        // XỬ LÝ "add"
        // -----------------------------
        if (action.equals("add")) {
            String productCode = request.getParameter("productCode");
            Product product = ProductIO.getProduct(productCode, path);

            LineItem lineItem = new LineItem(product, 1);
            cart.addItem(lineItem);

            url = "/cart.jsp";
        }

        // -----------------------------
        // XỬ LÝ "update"
        // -----------------------------
        else if (action.equals("update")) {
            String productCode = request.getParameter("productCode");
            int qty;

            try {
                qty = Integer.parseInt(request.getParameter("quantity"));
            } catch (NumberFormatException e) {
                qty = 0;
            }

            Product product = ProductIO.getProduct(productCode, path);
            LineItem item = new LineItem(product, qty);

            if (qty <= 0) {
                cart.removeItem(item);
            } else {
                cart.removeItem(item);
                cart.addItem(item);
            }

            url = "/cart.jsp";
        }

        // -----------------------------
        // XỬ LÝ "continue" → quay về trang products.jsp
        // -----------------------------
        else if (action.equals("continue")) {
            url = "/products.jsp";     // <<< QUAN TRỌNG
        }
        else if (action.equals("checkout")) {
    url = "/thanks.jsp";
}


        session.setAttribute("cart", cart);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
        
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
