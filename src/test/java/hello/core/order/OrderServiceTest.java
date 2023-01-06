package hello.core.order;


import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    void createOrder(){
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OderServiceImpl();

        Member member = new Member(1L,"HONG", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L,"Shelf",30000);

        Assertions.assertEquals(1000,order.getDiscountPrice());
    }
}
