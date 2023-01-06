package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    // private static がないと、storeメモリから削除されてメンバーを探そうとしても探せない
    private static Map<Long,Member> store = new HashMap<>();

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }
}
