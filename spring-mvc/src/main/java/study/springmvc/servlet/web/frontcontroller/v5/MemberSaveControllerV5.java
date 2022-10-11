package study.springmvc.servlet.web.frontcontroller.v5;

import java.util.Map;
import study.springmvc.servlet.domain.member.Member;
import study.springmvc.servlet.domain.member.MemberRepository;

public class MemberSaveControllerV5 implements ControllerV5 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);

        return "save-result";
    }
}
