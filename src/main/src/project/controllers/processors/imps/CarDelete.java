package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.CAR;
import static project.constants.AttributeConst.MSID;
import static project.constants.PageConst.CARSOFMS;

/**
 * Created on 16.08.2016.
 */
public class CarDelete implements RequestInterface {

    private CarService carService = new CarServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {


        carService.deleteCar(Util.getInteger(request, CAR));
        response.sendRedirect(CARSOFMS + Util.getInteger(request, MSID));
    }

}

