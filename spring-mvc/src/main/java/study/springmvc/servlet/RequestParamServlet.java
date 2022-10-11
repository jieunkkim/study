package study.springmvc.servlet;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    private HttpServletResponse response;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;

        String username = request.getParameter("username");
        String age = request.getParameter("age");

        String contentType = request.getContentType();
        String characterEncoding = request.getCharacterEncoding();

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        printToResponse(username + "님 반갑습니다. (나이 : " + age + ")");
        printToResponse("\n\n================= [ Header ] =================");
        printRequestHeader(request);
        printToResponse("\n\n================= [ Header ] =================");
        printRequestHeaderMore(request);
    }

    // Header Name 으로 직접 조회하기
    private void printRequestHeader(HttpServletRequest request) {
        request.getHeaderNames().asIterator().forEachRemaining(
            headerName -> printToResponse(headerName + " : " + request.getHeader(headerName))
        );
    }

    // Header 조회 메소드로 조회하기
    private void printRequestHeaderMore(HttpServletRequest request) {
        // Server Info (Host Info)
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        printToResponse("Server Info = " + serverName + ":" + serverPort);

        // Accept-Language
        printToResponse("Accept-Language = ");
        request.getLocales().asIterator().forEachRemaining(
            locale -> printToResponse(locale.toString())
        );
        Locale locale = request.getLocale();
        printToResponse("locale : " + locale.toString());

        // Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            printToResponse("Cookie = ");
            for (Cookie cookie : cookies) {
                printToResponse(cookie.getName() + " : " + cookie.getValue());
            }
        }

        // Set Response Content
        String contentType = request.getContentType();
        String characterEncoding = request.getCharacterEncoding();
        printToResponse("ContentType & Encoding = " + contentType + ";" + characterEncoding);

    }

    private void printToResponse(String message) {
        try {
            this.response.getWriter().println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
