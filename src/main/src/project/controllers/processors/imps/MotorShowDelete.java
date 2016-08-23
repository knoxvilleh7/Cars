package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.*;
import static project.constants.PageConst.MSALLCONT;

/**
 * Created on 16.08.2016.
 */
public class MotorShowDelete implements RequestInterface {

    private MShowService mShowService = new MShowServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {


        mShowService.delete(Util.getInteger(request, MSID));
        response.sendRedirect(MSALLCONT);
    }
}
