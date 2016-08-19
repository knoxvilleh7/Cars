package project.exception;

import java.util.List;
import java.util.Map;

/**
 * Created on 16.08.2016.
 */
public class ValidException extends Exception {

    private Map<String, List<String>> errs;

    public ValidException(Map<String, List<String>> msg) {
        errs = msg;
    }

    public Map<String, List<String>> getErrs() {
        return errs;
    }
}
