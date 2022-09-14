package hello.core.member;

public interface MemberService {

    //가입
    void join(Member member);

    //회원 조회회
    Member findMember(Long memberId);
}
