package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.MotorShow;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.*;
import static project.constants.PageConst.*;

/**
 * Created on 15.08.2016.
 */
public class MotorShowShowAll implements RequestInterface {


    private MShowService mShowService = new MShowServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {


        List<MotorShow> mShow = mShowService.getAllMotorShows();
        request.setAttribute(MOTORSHOW, mShow);
        request.getRequestDispatcher(MSALL).forward(request, response);
    }
}
