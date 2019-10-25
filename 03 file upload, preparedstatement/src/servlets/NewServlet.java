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
        //String name = request.getParameter("name");
        Student s = new Student();
        //s.setName(name);

        for (Part p : request.getParts()) {
            if ("name".equals(p.getName())) {
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                s.setName(br.readLine());
            } else if ("photo".equals(p.getName())) {
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
            }
        }

        studentDAO.save(s);
        response.sendRedirect("/list");
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        render(request, response, "new.ftl", null);
    }
}
