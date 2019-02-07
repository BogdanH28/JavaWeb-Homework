package ro.sci.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class AgeInDaysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("My age in days is: " + ageInDaysCalculator());
    }

    private int ageInDaysCalculator() {
        int yearOfBirth = 1995;
        int monthOfBirth = 12;
        int dayOfBirth = 28;

        LocalDate localDate = LocalDate.now();

        int currentYear = localDate.getYear();
        int currentMonth = localDate.getMonthValue();
        int currentDay = localDate.getDayOfMonth();

        return ((currentYear-yearOfBirth)*365 - Math.abs(currentMonth - monthOfBirth)*31 -
                Math.abs(currentDay - dayOfBirth));
    }
}
