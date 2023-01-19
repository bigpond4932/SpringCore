package hello.core.xml;

import hello.core.Config;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlBaseConfigTest {

    ApplicationContext ac = new GenericXmlApplicationContext("Config.xml");
    @Test
    @DisplayName("XML로 스프링 환경설정 해보기")
    public void xmlConfig(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        Member member = new Member(1L,"hong", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L,"Table",30000);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        Assertions.assertThat(order.getItemPrice()-order.getDiscountPrice()).isEqualTo(29000);
    }

}
