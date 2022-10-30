package study.springmvc.servlet.web.springmvc.old;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

/**
 * HandlerMapping = BeanNameUrlHandlerMapping
 * HandlerAdapter = HttpRequestHandlerAdapter (HttpRequestHandler를 지원하는 Adapter)
 */
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
