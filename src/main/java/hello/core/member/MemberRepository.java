package hello.core.member;

public interface MemberRepository {

    public Member findById(Long id);
    public void save(Member member);
}
