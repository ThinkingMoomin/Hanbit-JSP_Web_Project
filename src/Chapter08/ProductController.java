package Chapter08;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {

    ProductService service;

    public ProductController() {
        service = new ProductService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        String view = "";

        if (request.getParameter("action") == null) {
            getServletContext().getRequestDispatcher("/pcontrol?action=list")
                    .forward(request, response);
        } else {
            switch (action) {
                case "list": view = list(request, response); break;
                case "info": view = info(request, response); break;
            }
            getServletContext().getRequestDispatcher("/Chapter08/" + view)
                    .forward(request, response);
        }
    }

    private String list(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("products", service.findAll());
        return "productList.jsp";
    }

    private String info(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("p", service.find(request.getParameter("id")));
        return "productInfo.jsp";
    }
}
