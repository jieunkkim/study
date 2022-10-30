package study.springmvc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

@WebServlet(name = "requestBodyServlet", urlPatterns = "/request-body")
public class RequestBodyServlet extends HttpServlet {

    private HttpServletResponse response;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String requestBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        HelloUser helloUser = objectMapper.readValue(requestBody, HelloUser.class);

        // Set Response Content
        this.response = response;
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        printToResponse(helloUser.getUsername() + "님 반갑습니다. (나이 : " + helloUser.getAge() + ")");
    }

    private void printToResponse(String message) {
        try {
            this.response.getWriter().println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
