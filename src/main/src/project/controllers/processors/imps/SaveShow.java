package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.model.MotorShow;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.transformer.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 16.08.2016.
 */
public class SaveShow implements RequestInterface {
    private MotorShow motorShow = new MotorShow();
    private MShowService mShowService = new MShowServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        motorShow = Transformer.getMotorShowParams(request);
//        mShowService.mShowSave(motorShow);
//        response.sendRedirect("/motorshows");
    }
}
