package study.springmvc.basic.response;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import study.springmvc.basic.HelloData;

/**
 * @ResponseBody 를 사용하면
 * 뷰 리졸버대신 HttpMessageConverter가 동작한다 (StringHttpMessageConverter, MappingJackson2HttpMessageConverter)
 *
 * 스프링 MVC은 다음의 경우 HTTP 메시지 컨버터 적용
 * - 요청 : @RequestBody, HttpEntity(RequestEntity)
 * - 응답 : @ResponseBody, HttpEntity(ResponseEntity)
 */
@Slf4j
@Controller // @ResponseBody를 전체 메소드에 적용하고자 하는 경우 @RestController로 대체 가능
public class ResponseBodyController {

    @RequestMapping("response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }

}
