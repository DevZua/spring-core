package hello.core.member;

public interface MemberRepository {

    void save(Member member);  // 회원 저장

    Member findById(Long memberId);  // 회원 Id 로 회원을 찾는 기능
}
