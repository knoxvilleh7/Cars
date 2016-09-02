package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.exception.ValidException;
import project.model.MotorShow;
import project.service.MotorShowService;
import project.service.MotorShowServiceImpl;
import project.transformer.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.*;
import static project.constants.PagesConst.*;

/**
 * Created on 16.08.2016.
 */
public class MotorShowSave implements RequestInterface {

    private MotorShowService motorShowService;

    public void setMotorShowService(MotorShowService motorShowService) {
        this.motorShowService = motorShowService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        MotorShow motorShow = Transformer.getMotorShowParams(request);
        try {
            motorShowService.mShowSave(motorShow);
            response.sendRedirect(MSALLCONT);
        } catch (ValidException validException) {

            request.setAttribute(ERRS, validException.getErrs());
            request.setAttribute(MOTORSHOW, motorShow);
            request.getRequestDispatcher(MSEDIT).forward(request, response);
        }

    }
}
