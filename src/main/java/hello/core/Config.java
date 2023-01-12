package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OderServiceImpl;
import hello.core.order.OrderService;

public class Config {
    // MemberService 인터페이스가 호출될 때 필요한거 뭐 있어?
    // MemberService 구현체와 구현체가 의존하는 MemberServiceRepository
    // Config 리팩터링 문제 1. 중복 존재 2. 역할과 구현이 한 눈에 보이지 않는다.
    // => 코드만 보고도 무슨 역할이 있고 어떻게 구현했는지 알 수 있다.
    public MemberService memberService(){
        return new MemberServiceImpl(memoryMemberRepository());
    }

    private MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }


    public OrderService orderService(){
        return new OderServiceImpl(memoryMemberRepository(), fixedDiscountPolicy());
    }

    private FixDiscountPolicy fixedDiscountPolicy() {
        return new FixDiscountPolicy();
    }
}
