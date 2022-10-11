package study.springmvc.servlet.web.frontcontroller.v1;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.springmvc.servlet.domain.member.MemberRepository;

public class MemberListControllerV1 implements ControllerV1{

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("members", memberRepository.findAll());

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }
}
