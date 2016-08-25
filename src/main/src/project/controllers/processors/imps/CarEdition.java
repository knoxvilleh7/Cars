package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.Car;
import project.model.MotorShow;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.*;
import static project.constants.AttributeConst.ID;
import static project.constants.PagesConst.*;

/**
 * Created on 17.08.2016.
 */
public class CarEdition implements RequestInterface {
    private MShowService mShowService = new MShowServiceImpl();
    private CarService carService = new CarServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        Integer motorShowId = Util.getInteger(request, MSID);
        Integer id = Util.getInteger(request, CAR);
        if (motorShowId != null) {
            request.setAttribute(MSID, motorShowId);
        }
        if (id != null) {
            Car car = carService.getCarById(id);
            request.setAttribute(ID, id);
            request.setAttribute(CAR, car);
            request.setAttribute(MSID, car.getMotorShowId());
        } else {
            List<MotorShow> mShows = mShowService.getAllMotorShowsForRegistration();
            request.setAttribute(MSHOWS, mShows);
        }
        request.getRequestDispatcher(CAREDIT).forward(request, response);
    }
}




