package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.Car;
import project.model.MotorShow;
import project.service.CarService;
import project.service.CarServiceImpl;
import project.service.MotorShowService;
import project.service.MotorShowServiceImpl;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.*;
import static project.constants.AttributeConst.ID;
import static project.constants.PagesConst.*;

public class CarEdition implements RequestInterface {

    private MotorShowService motorShowService;
    private CarService carService;

    public void setMotorShowService(MotorShowService motorShowService) {
        this.motorShowService = motorShowService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        Integer motorShowId = Util.getInteger(request, MSID);
        Integer id = Util.getInteger(request, CAR);
        if (motorShowId != null) {
            request.setAttribute(MSID, motorShowId);
        }
        if (id != null) {
            Car car = this.carService.getCarById(id);
            request.setAttribute(ID, id);
            request.setAttribute(CAR, car);
            request.setAttribute(MSID, car.getMotorShowId());
        } else {
            List<MotorShow> mShows = this.motorShowService.getAllMotorShowsForRegistration();
            request.setAttribute(MSHOWS, mShows);
        }
        request.getRequestDispatcher(CAREDIT).forward(request, response);
    }
}




