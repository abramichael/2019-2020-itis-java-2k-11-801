import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        request.setAttribute("name", name);
        RequestDispatcher rd = request.getRequestDispatcher("/hello_page");
        rd.forward(request, response);
    }
}
