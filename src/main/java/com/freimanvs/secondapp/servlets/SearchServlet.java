package com.freimanvs.secondapp.servlets;

import com.freimanvs.company.entities.Employee;
import com.freimanvs.company.jsp.beans.interfaces.SearchBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/search"}, name = "searchServlet", asyncSupported = true)
public class SearchServlet extends HttpServlet {

    @EJB
    private SearchBean searchBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/data-base.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String fio = req.getParameter("fio");
        String pos = req.getParameter("position");
        String city = req.getParameter("city");
        String ageFromString = req.getParameter("ageFrom");
        String ageToString = req.getParameter("ageTo");
        int ageFrom = ageFromString.equals("") ? 1 : Integer.parseInt(ageFromString);
        int ageTo = ageToString.equals("") ? 999 : Integer.parseInt(ageToString);

        List<Employee> list = searchBean.getBy(login, fio, pos, city, ageFrom, ageTo);

        try (PrintWriter pw = resp.getWriter()) {
            list.forEach(pw::println);
        }
    }
}