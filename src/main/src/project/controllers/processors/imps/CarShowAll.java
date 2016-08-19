package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.dao.CarDao;
import project.dao.CarDaoImpl;
import project.exception.DaoException;
import project.model.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.CARS;
import static project.constants.AttributeConst.ERRS;
import static project.constants.PageConst.CARSALL;
import static project.constants.PageConst.EXCEPLIST;

/**
 * Created on 16.08.2016.
 */
public class CarShowAll implements RequestInterface {

    private CarDao carDao = new CarDaoImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {


        List<Car> cars = carDao.getCars();
        request.setAttribute(CARS, cars);
        request.getRequestDispatcher(CARSALL).forward(request, response);
    }

}

