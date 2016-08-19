package project.controllers;

import project.controllers.processors.RequestInterface;
import project.controllers.processors.imps.*;
import project.exception.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created on 15.08.2016.
 */
public class Controller extends HttpServlet {

    private static final HashMap<String, RequestInterface> PROCESSORS = new HashMap<String, RequestInterface>() {{
        put("/", new DefaultUrl());
        put("/motorshows", new MotorShowShowAll());
        put("/motorshowedition", new MotorShowEdition());
        put("/mssave", new MotorShowSave());
        put("/deleteshow", new MotorShowDelete());
        put("/mscars", new MotorShowAllCarsShow());
        put("/carsave", new CarSave());
        put("/deletecar", new CarDelete());
        put("/cars", new CarShowAll());
        put("/caredition", new CarEdition());
    }};

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI().replace(req.getContextPath(),"");
        System.out.println(url);
        RequestInterface requestInterface = PROCESSORS.get(url);
        if (requestInterface != null) {
            try {
                requestInterface.method(req, resp);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }
}
