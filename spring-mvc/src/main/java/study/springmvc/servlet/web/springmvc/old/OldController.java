package study.springmvc.servlet.web.springmvc.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * HandlerMapping = BeanNameUrlHandlerMapping
 * HandlerAdapter = SimpleControllerHandlerAdapter (Controller를 지원하는 Adapter (@Controller와 무관)
 *
 * ViewResolver
 * SpringBoot는 InternalResourceViewResolver 라는 뷰 리졸버를 자동으로 등록하는데,
 * 이 리졸버는 application.properties에 등록한 spring.mvc.view.prefix, spring.mvc.view.suffix를 참조
 */
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
