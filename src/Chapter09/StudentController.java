package Chapter09;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/studentControl")
public class StudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    StudentDAO dao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new StudentDAO();
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String view = "";

        if (request.getParameter("action") == null) {
            getServletContext().getRequestDispatcher("/studentControl?action=list")
                    .forward(request, response);
        } else {
            switch (action) {
                case "list": view = list(request, response); break;
                case "insert": view = insert(request, response); break;
            }
            getServletContext().getRequestDispatcher("/Chapter09/" + view)
                    .forward(request, response);
        }
    }

    public String list(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("students", dao.getAll());
        return "../Chapter09/studentInfo.jsp";
    }

    public String insert(HttpServletRequest request, HttpServletResponse response) {

        Student s = new Student();
        try {
            BeanUtils.populate(s, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        dao.insert(s);
        return list(request, response);
    }

}
