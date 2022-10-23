package study.springmvc.basic.request;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestHeaderController {

    /**
     *
     * @RequestHeader MultiValueMap<String, String> headerMap
     * 모든 HTTP 헤더를 MultiValueMap 형식으로 조회. MultiValueMap은 key 중복 허용함
     *
     * @RequestHeader("host") String host
     * 특정 HTTP 헤더 조회
     */
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request, HttpServletResponse response,
        HttpMethod httpMethod, Locale locale, @RequestHeader MultiValueMap<String, String> headerMap,
        @RequestHeader("host") String host, @CookieValue(value = "myCookie", required = false) String cookie) {
        log.info("request = {}", request);
        log.info("response = {}", response);
        log.info("httpMethod = {}", httpMethod);
        log.info("locale = {}", locale);
        log.info("headerMap = {}", headerMap);
        log.info("header host = {}", host);
        log.info("myCookie = {}", cookie);

        return "ok";
    }
}
