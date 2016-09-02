package project.service;

import project.model.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 25.08.2016.
 */
public interface PageService {

    Long getNumberOfPages(Long Cars, Integer NumberOfCars);

    Page getPageForAllCars(HttpServletRequest request);

    Page getPageForSearchCars(HttpServletRequest request, Object searchValue, String searchCategory);

    Page getPageForAllMotorShows(HttpServletRequest request);

    Page getPageForSearchMotorShows(HttpServletRequest request, Object searchValue, String searchCategory);

    Page getPageForCarsInMotorShow(HttpServletRequest request, Integer motorShowId);

    Page getPageForSearchCarsInMotorShow(HttpServletRequest request, Object searchValue, String searchCategory, Integer motorShowId);
}
