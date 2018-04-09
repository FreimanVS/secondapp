package com.freimanvs.secondapp.servlets;

import com.freimanvs.company.util.interfaces.FileManagerBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/file")
public class FileManagerServlet extends HttpServlet {

    @EJB
    FileManagerBean fileManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter pw = resp.getWriter()) {
            pw.println("Write HELLO2 to the file \"hello.txt\"");
            fileManagerBean.writeToFile("HELLO2", "./hello.txt");
        }
    }
}