package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //가입
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    //회원 조회
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findbyId(memberId);
    }
}
