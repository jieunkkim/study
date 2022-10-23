package study.springmvc.basic.request;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 요청 파라미터와 다르게 HTTP 메시지 바디를 통해 데이터가 직접 넘어오는 경우
 *
 * @RequestParam, @ModelAttribute 사용이 불가능하다
 * <p>
 * HTTP message body에 데이터를 직접 담아서 요청 - HTTP API에서 주로 사용 - 데이터 형식은 주로 JSON 사용 - POST, PUT, PATCH
 */

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);
        response.getWriter().write("ok");
    }

    /**
     * 스프링 MVC는 다음 파라미터를 지원한다 - InputStream(Reader) : HTTP 요청 메시지 바디 내용을 직접 조회 - OuputStream(Writer)
     * : HTTP 요청 메시지의 바디에 직접 결과 출력
     */
    @PostMapping("/request-body-string-v2")
    public void requestBodyString(InputStream inputStream, Writer responseWriter)
        throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);
        responseWriter.write("ok");
    }

    /**
     * HttpEntity
     * - HTTP header, body 정보를 편리하게 조회
     * - 메시지 바디정보 직접 조회
     * - 요청 파라미터를 조회하는 기능과 관계 없음 (@RequestParam X, @ModelAttribute X)
     * - 응답에도 사용 가능 (메시지 바디 정보 직접 반환, 헤더 정보도 포함 가능)
     *
     * RequestEntity, ResponseEntity
     * - HttpEntity를 상속받은 객체들로 다음같은 기능 제공
     * - RequestEntity : HttpMethod, url 정보가 추가됨. 요청에서 사용가능
     * - ResponseEntity : HTTP 상태코드 설정 가능. 응답에서 사용
     * (ex. return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED)
     */
    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) {
        String messageBody = httpEntity.getBody();
        log.info("messageBody={}", messageBody);

        return new HttpEntity<>("ok");
    }

    /**
     * @RequestBody - 메시지 바디 정보 직접 조회 - HttpMessageConverter 사용 -> StringHttpMessageConverter 적용
     * @ResponseBody - 메시지 바디 정보 직접 반환 (view 조회) - HttpMessageConverter 사용 ->
     * StringHttpMessageConverter 적용
     *
     * @RequestBody에서 헤더정보가 필요하다면 @RequestHeader나 HttpEntity를 사용
     */

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {
        log.info("messageBody={}", messageBody);
        return "ok";
    }

}
