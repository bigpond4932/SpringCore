package hello.core.member;

import hello.core.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class memberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        Config config = new Config();
        memberService = config.memberService();
    }

    @Test
    void join(){
        // given
        Member member = new Member(1L,"hong", Grade.VIP);
        // when
        memberService.join(member);
        Member joinedMember = memberService.findMember(member.getId());
        // then
        Assertions.assertEquals(member.getId(),joinedMember.getId());
    }

}
