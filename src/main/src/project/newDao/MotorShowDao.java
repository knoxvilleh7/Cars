package project.newDao;

import project.model.MotorShow;

import java.util.List;

/**
 * Created on 22.08.2016.
 */
public interface MotorShowDao extends NewDaoGenerics<MotorShow>{

    List<MotorShow> getAllMotorShowsForRegistration();

}
