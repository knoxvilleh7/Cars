package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.Car;
import project.model.Page;
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
import static project.constants.PagesConst.DEFAULTPAGENUMBER;
import static project.constants.PagesConst.DEFAULTPAGESIZE;
import static project.constants.PagesConst.MSALLCARS;

/**
 * Created on 16.08.2016.
 */
public class MotorShowAllCarsShow implements RequestInterface {

    private CarService carService = new CarServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

        Integer motorShowId = Util.getInteger(request, MSID);

        Page page = Transformer.getPageParam(request);
        if (page.getPageSize() == null) {
            page.setPageSize(DEFAULTPAGESIZE);
        }
        if (page.getPageNumber() == null) {
            page.setPageNumber(DEFAULTPAGENUMBER);
        }
        page.setPageCount(getNumberOfPages(carService.getCarOfShowCount(motorShowId), page.getPageSize()));
        page.setToNext(page.getPageNumber()<page.getPageCount());
        page.setToPrev(page.getPageNumber()>1);
        List<Car> cars = carService.getCarsByMSId(motorShowId, page.getPageNumber(), page.getPageSize());
        request.setAttribute(CARS, cars);
        request.setAttribute(MSID, motorShowId);
        request.setAttribute(PAGE, page);
        request.getRequestDispatcher(MSALLCARS).forward(request, response);

    }
    private Long getNumberOfPages(Long Cars, Integer NumberOfCars) {
        Long l = (Cars / NumberOfCars);
        if (Cars % NumberOfCars != 0) {
            l++;
        }
        return l;
    }


}

