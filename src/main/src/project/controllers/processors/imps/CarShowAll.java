package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.Car;
import project.newDao.CarDao;
import project.newDao.CarDaoImpl;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.CARS;
import static project.constants.PageConst.CARSALL;

/**
 * Created on 16.08.2016.
 */
public class CarShowAll implements RequestInterface {

    private CarService carService = new CarServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {


        List<Car> cars = carService.getCars();
        request.setAttribute(CARS, cars);
        request.getRequestDispatcher(CARSALL).forward(request, response);
    }

}

