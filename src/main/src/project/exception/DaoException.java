package project.exception;

/**
 * Created on 19.08.2016.
 */
public class DaoException extends Exception{

    String error;

    public DaoException(String message) {
        error = message;
    }


    public String getErrs(){
        return error;
    }

}
