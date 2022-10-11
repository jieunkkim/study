package study.springmvc.servlet.web.frontcontroller.v3;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
