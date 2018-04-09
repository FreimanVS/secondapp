package com.freimanvs.secondapp.servlets;

import com.freimanvs.company.analytics.beans.interfaces.AnalyticsBean;
import com.freimanvs.company.service.interfaces.EmployeeServicePersInterface;
import com.freimanvs.company.service.interfaces.PositionServicePersInterface;
import com.freimanvs.company.service.interfaces.RoleServicePersInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dao")
public class DaoServlet extends HttpServlet {

    @EJB
    private EmployeeServicePersInterface employeeService;

    @EJB
    private RoleServicePersInterface roleServicePersInterface;

    @EJB
    private PositionServicePersInterface positionServicePersInterface;

    @EJB
    private AnalyticsBean analyticsBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter pw = resp.getWriter()) {
            pw.println("ALL EMPLOYEES");
            pw.println(employeeService.getList());
            pw.println();

            pw.println("ALL ROLES");
            pw.println(roleServicePersInterface.getList());
            pw.println();

            pw.println("ALL POSITIONS");
            pw.println(positionServicePersInterface.getList());
            pw.println();

            pw.println("ALL ANALYTICS");
            pw.println(analyticsBean.getAll());
        }
    }
}
