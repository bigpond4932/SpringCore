package hello.core.constructor;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WhyConstructorInjection {

    @Test
    @DisplayName("ConstructorInjection")
    void Test(){
        MemberRepository memberRepository = new MemoryMemberRepository();
        Member Shiori = new Member(1L,"Shiori", Grade.VIP);
        memberRepository.save(Shiori);
        OrderServiceImpl orderServicerImpl = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderServicerImpl.createOrder(1L,"Shiori",300000);

        Assertions.assertThat(order.getItemPrice()).isEqualTo(300000);

    }


}
