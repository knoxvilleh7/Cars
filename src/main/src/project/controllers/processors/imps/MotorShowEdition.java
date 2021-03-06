package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.MotorShow;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.*;
import static project.constants.PageConst.EXCEPLIST;
import static project.constants.PageConst.MSEDIT;

/**
 * Created on 16.08.2016.
 */
public class MotorShowEdition implements RequestInterface {

    private MShowService mShowService = new MShowServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        Integer motorShowId = Util.getInteger(request, MSID);
        if (motorShowId != null) {

            MotorShow motorShow = mShowService.getMShowById(motorShowId);
            request.setAttribute(MOTORSHOW, motorShow);
        }
        request.getRequestDispatcher(MSEDIT).forward(request, response);
    }
}
