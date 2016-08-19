package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.exception.ValidException;
import project.model.MotorShow;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.transformer.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.*;
import static project.constants.PageConst.*;

/**
 * Created on 16.08.2016.
 */
public class MotorShowSave implements RequestInterface {
    private MotorShow motorShow = new MotorShow();
    private MShowService mShowService = new MShowServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        motorShow = Transformer.getMotorShowParams(request);
        try {
            mShowService.mShowSave(motorShow);
            response.sendRedirect(MSALLCONT);
        } catch (ValidException validException) {

            request.setAttribute(ERRS, validException.getErrs());
            request.setAttribute(MOTORSHOW, motorShow);
            request.getRequestDispatcher(MSEDIT).forward(request, response);
        }

    }
}
