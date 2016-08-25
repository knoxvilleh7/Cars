package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.PagesConst.START;

/**
 * Created on 15.08.2016.
 */
public class DefaultUrl implements RequestInterface {

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(START).forward(request, response);
    }
}
