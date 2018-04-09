package com.freimanvs.secondapp.guessnumber.servlets;

import com.freimanvs.secondapp.guessnumber.beans.interfaces.GuessBean;
import com.freimanvs.secondapp.guessnumber.entities.Guesser;
import com.freimanvs.secondapp.guessnumber.service.beans.interfaces.GuesserServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/guessnumber")
public class GuessNumberServlet extends HttpServlet {

    @EJB
    private GuesserServiceBean guesserServiceBean;

    @EJB
    private GuessBean guessBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Byte number = Byte.parseByte(req.getParameter("number"));

        int randomInt = ((int)(Math.random() * 100)) % 10;

        Guesser guesser = guesserServiceBean.getByName(name);

        //if the user exists
        if (guesser != null) {

            //if too many tries
            if (guesser.getCount() >= 3) {
                guessBean.timeOut();
                guesser.setCount((byte)0);
                guesserServiceBean.updateById(guesser.getId(), guesser);
                req.getRequestDispatcher("/jsp/guessnumber.jsp").include(req, resp);
            }

            //if less than 3 tries
            else {
                try (PrintWriter pw = resp.getWriter()) {
                    pw.println("guessed number is " + randomInt);
                    pw.println("your number is " + number);

                    //if guessed
                    if (number == randomInt) {
                        pw.println("You won!");

                        guesser.setCount((byte)0);
                    }
                    //if didn't guess
                    else {
                        pw.println("You didn't guess");
                        guesser.setCount((byte)(guesser.getCount() + 1));
                        pw.println(String.format("You have %d more tries", 3 - guesser.getCount()));
                    }
                }

                guesserServiceBean.updateById(guesser.getId(), guesser);
            }
        }
        //if it is a new user
        else {
            try (PrintWriter pw = resp.getWriter()) {
                pw.println("guessed number is " + randomInt);
                pw.println("your number is " + number);

                Long id = guesserServiceBean.add(new Guesser(name));
                guesser = guesserServiceBean.getById(id);


                //if guessed
                if (number == randomInt) {
                    pw.println("You won!");

                    guesser.setCount((byte)0);
                }
                //if didn't guess
                else {
                    pw.println("You didn't guess");
                    pw.println(String.format("You have %d more tries", 3 - guesser.getCount()));
                }


                guesserServiceBean.updateById(guesser.getId(), guesser);
            }
        }
    }
}
