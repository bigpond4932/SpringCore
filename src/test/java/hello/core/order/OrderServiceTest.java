package hello.core.order;


import hello.core.Config;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;


    @Test
    void createOrder(){
        Config config = new Config();
        memberService = config.memberService();
        orderService = config.orderService();
        Member member = new Member(1L,"HONG", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L,"Shelf",30000);

        Assertions.assertEquals(3000,order.getDiscountPrice());
    }
}
