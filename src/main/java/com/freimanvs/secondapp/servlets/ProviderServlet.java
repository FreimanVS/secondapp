package com.freimanvs.secondapp.servlets;

import com.freimanvs.company.soapjaxws.cities.beans.interfaces.Provider;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/provider")
public class ProviderServlet extends HttpServlet {

    @EJB
    private Provider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf8");
        try (PrintWriter pw = resp.getWriter()) {
            pw.println(provider.getResponse(req.getParameter("url")));
        }
    }
}
