package study.springmvc.servlet.web.frontcontroller.v3;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.springmvc.servlet.domain.member.MemberRepository;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        ModelView mv = new ModelView("members");
        mv.getModel().put("members", memberRepository.findAll());
        return mv;

    }
}
