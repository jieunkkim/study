package study.springmvc.servlet.web.frontcontroller.v5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.springmvc.servlet.web.frontcontroller.v3.ModelView;

public interface MyHandlerAdapter {

    boolean support(Object handler);
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws ServletException, IOException;

}
