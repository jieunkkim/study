package study.springmvc.servlet.web.frontcontroller.v2;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.springmvc.servlet.domain.member.MemberRepository;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("members", memberRepository.findAll());

        String viewPath = "/WEB-INF/views/members.jsp";
        return new MyView(viewPath);
    }
}
