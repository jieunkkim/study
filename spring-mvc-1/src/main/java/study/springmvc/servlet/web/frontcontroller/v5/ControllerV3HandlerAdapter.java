package study.springmvc.servlet.web.frontcontroller.v5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.springmvc.servlet.web.frontcontroller.v3.ControllerV3;
import study.springmvc.servlet.web.frontcontroller.v3.ModelView;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter{

    @Override
    public boolean support(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;
        return controller.process(createParamMap(request));
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(
            paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
