package study.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 스프링부트는 classpath 다음 디렉토리에 있는 정적 리소스를 제공
 * /static, /public, /resources, /META-INF/resources
 *
 * src/main/resources는 리소스를 보관하는 곳이고, 클래스패스 시작 경로
 * 따라서 아래처럼 디렉토리에 리소스 넣어두면 스프링 부트가 정적 리소스로 서비스 제공
 *
 * src/main/resources/static
 * src/main/resources/static/basic/hello-form.html
 * (웹 브라우저 실행 시 /basic/hello-form.html)
 *
 * 스프링부트는 기본 뷰 템플릿 경로도 제공한다 (hello.html경우 타임리프가 implement 되어 있어야 함)
 * src/main/resoruces/templates
 */

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
            .addObject("data", "hello!");
        return mav;
    }

    /**
     * String을 반환하는 경우
     * @ResponseBody가 없으면 response/hello로 뷰 리졸버가 실행되고 뷰를 찾은 후 랜더링됨
     * @ResponseBody가 있다면 뷰 리졸버를 실행하지 않고, HTTP 메시지 바디에 직접 response/hello 입력됨
     */
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    /**
     * void를 반환하는 경우 (권장하지 않음)
     * @Controller를 사용하고, HttpServletResponse, OutputStream(Writer) 같은
     * HTTP 메시지 바디를 처리하는 요청 파라미터가 없으면 요청 URL을 참고해서 논리 뷰 이름으로 사용
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello!");
    }

}
