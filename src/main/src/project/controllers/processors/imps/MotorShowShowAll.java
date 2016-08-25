package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.MotorShow;
import project.model.Page;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.transformer.Transformer;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.*;
import static project.constants.PagesConst.*;

/**
 * Created on 15.08.2016.
 */
public class MotorShowShowAll implements RequestInterface {


    private MShowService mShowService = new MShowServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

        Page page = Transformer.getPageParam(request);
        if (page.getPageSize() == null) {
            page.setPageSize(DEFAULTPAGESIZE);
        }
        if (page.getPageNumber() == null) {
            page.setPageNumber(DEFAULTPAGENUMBER);
        }
        page.setPageCount(getNumberOfPages(mShowService.getMotorShowCount(), page.getPageSize()));
        List<MotorShow> motorShows = mShowService.getAllMotorShows(page.getPageNumber(), page.getPageSize());
        request.setAttribute(MOTORSHOW, motorShows);
        request.setAttribute(PAGE, page);
        request.getRequestDispatcher(MSALL).forward(request, response);
    }

    private Long getNumberOfPages(Long MotorShows, Integer NumberOfMotorShows) {
        Long l = (MotorShows / NumberOfMotorShows);
        if ( MotorShows % NumberOfMotorShows != 0) {
            l++;
        }
        return l;
    }

}
