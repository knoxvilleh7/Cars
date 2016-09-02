package project.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created on 02.09.2016.
 */
@Component
public class SpringUtils {
    private static ApplicationContext context;

    static <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        SpringUtils.context = context;
    }
}
