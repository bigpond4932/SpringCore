package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Config {
    // MemberService 인터페이스가 호출될 때 필요한거 뭐 있어?
    // MemberService 구현체와 구현체가 의존하는 MemberServiceRepository
    // Config 리팩터링 문제 1. 중복 존재 2. 역할과 구현이 한 눈에 보이지 않는다.
    // => 코드만 보고도 무슨 역할이 있고 어떻게 구현했는지 알 수 있다.

    // new Member
    @Bean
    public MemberService memberService(){
        System.out.println("Call memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("Call memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){

        System.out.println("Call orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        // setter주입시, 객체 성성시 파라미터로 받을 필요 없음.
//        return new OrderServiceImpl();
        return null;
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("Call discountPolicy");
        return new RateDiscountPolicy();
        // return new FixedDiscountPolicy();
    }

    // @Configuration
}
