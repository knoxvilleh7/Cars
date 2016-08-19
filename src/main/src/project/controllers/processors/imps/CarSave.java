package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.dao.MotorShowDao;
import project.dao.MotorShowDaoImpl;
import project.exception.DaoException;
import project.exception.ValidException;
import project.model.Car;
import project.model.MotorShow;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;
import project.transformer.Transformer;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.*;
import static project.constants.MotorShowConst.*;
import static project.constants.PageConst.*;

/**
 * Created on 16.08.2016.
 */
public class CarSave implements RequestInterface {

    private CarService carService = new CarServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        Car car = Transformer.getCarParam(request);
        Integer m = Util.getInteger(request, MSIDFS);
        if (m == null) {
            car.setMotorShowId(Util.getInteger(request, MSIDFH));
        } else {
            car.setMotorShowId(m);
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
