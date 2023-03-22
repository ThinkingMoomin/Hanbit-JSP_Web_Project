package Chapter08;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/calcControl")
public class CalcController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CalcController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));

        long result = 0;

        switch (request.getParameter("op")) {
            case "+": result = n1 + n2; break;
            case "-": result = n1 - n2; break;
            case "*": result = n1 * n2; break;
            case "/": result = n1 / n2; break;
        }

        request.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/Chapter08/calcResult.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
