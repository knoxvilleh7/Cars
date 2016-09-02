package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.exception.ValidException;
import project.model.Car;
import project.service.CarService;
import project.service.CarServiceImpl;
import project.service.MotorShowService;
import project.service.MotorShowServiceImpl;
import project.transformer.Transformer;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.*;
import static project.constants.PagesConst.CAREDIT;
import static project.constants.PagesConst.CARSOFMS;

/**
 * Created on 16.08.2016.
 */
public class CarSave implements RequestInterface {

    private MotorShowService motorShowService;
    private CarService carService;

    public void setMotorShowService(MotorShowService motorShowService) {
        this.motorShowService = motorShowService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        Car car = Transformer.getCarParam(request);
        Integer m = Util.getInteger(request, MSIDFS);

        if (m == null) {
            Integer motorShowId = Util.getInteger(request, MSIDFH);
            car.setMotorShowId(motorShowId);
            car.setMotorShow(motorShowService.getMShowById(motorShowId));
        } else {
            car.setMotorShowId(m);
            car.setMotorShow(motorShowService.getMShowById(m));
        }
        try {
            carService.saveCar(car);
            response.sendRedirect(CARSOFMS + car.getMotorShowId());
        } catch (ValidException validException) {
            request.setAttribute(ID, car.getId());
            request.setAttribute(CAR, car);
            request.setAttribute(ERRS, validException.getErrs());
            request.setAttribute(MSID, car.getMotorShowId());
            request.getRequestDispatcher(CAREDIT).forward(request, response);
        }
    }
}
