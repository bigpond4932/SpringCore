package hello.core.singleton;

import hello.core.Config;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Config conf = ac.getBean(Config.class);
        System.out.println("conf = " + conf);

        // Config$$EnhancerBySpringCGLIB$$5ca60635@51133c06 -> @Configuration이 달려있을 때
        // hello.core.Config@68878f6d -> 안 달려있을 때
        MemberRepository memberRepository0 = ac.getBean(MemberRepository.class);
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);

        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository0 = " + memberRepository0);
        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);

//        Assertions.assertThat(memberRepository1).isNotSameAs(memberRepository2);
        // @Configuration(x)일 때만 성공 싱글톤 보장 안 함 -> 붙어있을 때는 isSameAs (O)
//        Assertions.assertThat(memberRepository0).isNotSameAs(memberRepository1);
//        Assertions.assertThat(memberRepository1).isNotSameAs(memberRepository2);
//        Assertions.assertThat(memberRepository0).isNotSameAs(memberRepository2);

    }
}
