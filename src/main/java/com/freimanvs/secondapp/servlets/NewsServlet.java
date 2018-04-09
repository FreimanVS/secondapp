package com.freimanvs.secondapp.servlets;

import com.freimanvs.company.html.ObjForJson;
import com.freimanvs.company.html.beans.interfaces.JsoupBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    @EJB
    private JsoupBean jsoupBean;


    private static final Gson JSON = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF8");

        try (PrintWriter pw = resp.getWriter()) {
            pw.println("ALL NEWS");
            List<ObjForJson> list = jsoupBean.getNews();
            String jsonString = JSON.toJson(list);
            pw.println(jsonString);
        }
    }
}