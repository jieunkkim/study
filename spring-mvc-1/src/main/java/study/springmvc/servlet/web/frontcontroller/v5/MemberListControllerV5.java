package study.springmvc.servlet.web.frontcontroller.v5;

import java.util.Map;
import study.springmvc.servlet.domain.member.MemberRepository;

public class MemberListControllerV5 implements ControllerV5 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        model.put("members", memberRepository.findAll());
        return "members";

    }
}
