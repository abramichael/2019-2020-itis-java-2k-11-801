package servlets;

import dao.StudentDAOImpl;
import models.Student;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.*;

import static helpers.FreemarkerHelper.render;

@MultipartConfig
public class NewServlet extends javax.servlet.http.HttpServlet {
    private StudentDAOImpl studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAOImpl();
    }

	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		
		Student s = new Student();
        String name = request.getParameter("name");
        s.setName(name);

        Part p = request.getPart("photo");
        String localdir = "uploads";
        String pathDir = getServletContext().getRealPath("") + File.separator + localdir;
        File dir = new File(pathDir);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String[] filename_data = p.getSubmittedFileName().split("\\.");
        String filename = Math.random() + "." + filename_data[filename_data.length - 1];
        String fullpath = pathDir + File.separator + filename;
        p.write(fullpath);
        s.setPhotoPath("/" + localdir + "/" + filename);

        studentDAO.save(s);
        response.sendRedirect("/list");
	}


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        render(request, response, "new.ftl", null);
    }
}
