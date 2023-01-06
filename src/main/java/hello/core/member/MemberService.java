package hello.core.member;

public interface MemberService {

    // 会員加入
    void join(Member member);
    // 会員閲覧
    Member findMember(Long id);

}
