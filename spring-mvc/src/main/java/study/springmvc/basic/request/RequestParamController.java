package study.springmvc.basic.request;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import study.springmvc.basic.HelloData;

/**
 * GET - 쿼리 파라미터 ex) /url?username=hello&age=20 검색, 필터, 페이징 등에서 많이 사용
 *
 * POST - HTML Form content-typ:application/x-www-form-urlencoded 메시지 body에 쿼리 파라미터 형식으로 전달 회원 가입,
 * 상품 주문, HTML Form 사용
 *
 * HTTP message body에 데이터 직접 담아서 요청 HTTP API에서 주로 사용 JSON, XML, TEXT 데이터 형식은 주로 JSON 사용 POST, PUT,
 * PATCH
 */

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("ok");
    }

    /**
     * class는 Controller지만 메서드에서 @ResponseBody를 사용한 경우 return Type이 String이어도 뷰를 찾지 않고 message body에
     * return 값을 그대로 담아 전달
     */
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
        @RequestParam("username") String memberName,
        @RequestParam("age") int memberAge) {
        log.info("memberName = {}, memberAge = {}", memberName, memberAge);
        return "ok";
    }

    /**
     * @RequestParam에서 (" username ") 생략
     */
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
        @RequestParam String username,
        @RequestParam int age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    /**
     * @RequestParam도 생략 단, @RequestParam 생략 시 required 가 true로 자동 적용
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    /**
     * required 옵션 적용 단, age의 경우 null이 올 수 있어 Integer로 변경
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
        @RequestParam(required = true) String username,
        @RequestParam(required = false) Integer age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    /**
     * defaultValue 적용 defaultValue는 빈 문자의 경우도 적용됨 (ex. /username=) 기본 값이 셋팅되었기 때문에 required는 사실 의미가
     * 없어짐
     */
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
        @RequestParam(required = true, defaultValue = "guest") String username,
        @RequestParam(required = false, defaultValue = "-1") Integer age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    /**
     * @RequestParam Map, MultiValueMap Map(key=value) MultiValueMap(key=[value1, value2, ..])
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
        @RequestParam Map<String, Object> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    /**
     * @ModelAttribute 실행 순서 HelloData 객체 생성 -> 요청 파라미터 이름과 동일한 HelloData 객체의 프로퍼티를 찾는다 -> 해당 프로퍼티의
     * setter를 호출해 파라미터 값을 입력(바인딩) 한다
     * <p>
     * BindException 숫자가 들어와야 할 곳에 문자가 들어온다거나 형식에 맞지 않는 값이 들어오면 발생한다
     */
    @ResponseBody
    @RequestMapping("/request-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    /**
     * @ModelAttribute도 생략 가능 보통 단순 타입을 파라미터로 받을 때 @RequestParam을 사용하고, model 객체를 받을 땐
     * @ModelAttribute를 사용한다.
     */
    @ResponseBody
    @RequestMapping("/request-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

}
