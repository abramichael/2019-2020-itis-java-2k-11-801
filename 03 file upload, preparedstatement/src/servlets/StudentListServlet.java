package servlets;

import dao.StudentDAOImpl;
import helpers.FreemarkerHelper;
import static helpers.FreemarkerHelper.render;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentListServlet extends javax.servlet.http.HttpServlet {

    private StudentDAOImpl studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAOImpl();
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        root.put("students", studentDAO.getAll());
        render(request, response, "list.ftl", root);
    }
}
