package study.springmvc.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HandlerMapping = RequestMappingHandlerMapping (스프링 Bean 중 class 레벨에 @RequestMapping, @Controller가
 * 붙어 있는 경우 지원) HandlerAdapter = RequestMappingHandlerAdapter (@RequestMapping을 지원)
 * <p>
 * 참고. 만약 @RequestMapping을 class 레벨에 붙여 HandlerMapping을 먹이고 싶은 경우, Bean 등록은 따로 해줘야 한다. (@Component 를
 * 붙여도 되고, Application 띄워지는 main 쪽에 직접 @Bean 등록해도 됨)
 */

@Controller // 내부에서 @Component 호출되어 스캔 대상에 포함됨
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
