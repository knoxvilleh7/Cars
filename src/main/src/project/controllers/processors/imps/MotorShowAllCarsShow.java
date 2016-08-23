package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.Car;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.*;
import static project.constants.PageConst.MSALLCARS;

/**
 * Created on 16.08.2016.
 */
public class MotorShowAllCarsShow implements RequestInterface {

    private CarService carService = new CarServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

        Integer motorShowId = Util.getInteger(request, MSID);

        List<Car> cars = carService.getCarsByMSId(motorShowId);
        request.setAttribute(CARS, cars);
        request.setAttribute(MSID, motorShowId);
        request.getRequestDispatcher(MSALLCARS).forward(request, response);

    }

}

