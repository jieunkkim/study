package study.springmvc.servlet.web.frontcontroller.v4;

import java.util.Map;
import study.springmvc.servlet.domain.member.MemberRepository;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        model.put("members", memberRepository.findAll());
        return "members";

    }
}
