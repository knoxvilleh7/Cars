package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.exception.ValidException;
import project.model.Car;
import project.model.MotorShow;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.transformer.Transformer;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.*;
import static project.constants.PageConst.CAREDIT;
import static project.constants.PageConst.CARSOFMS;

/**
 * Created on 16.08.2016.
 */
public class CarSave implements RequestInterface {

    private CarService carService = new CarServiceImpl();
    private MShowService mShowService = new MShowServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        Car car = Transformer.getCarParam(request);
        Integer m = Util.getInteger(request, MSIDFS);

        if (m == null) {
            Integer motorShowId = Util.getInteger(request, MSIDFH);
            car.setMotorShowId(motorShowId);
            car.setMotorShow(mShowService.getMShowById(motorShowId));
        } else {
            car.setMotorShowId(m);
            car.setMotorShow(mShowService.getMShowById(m));
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
