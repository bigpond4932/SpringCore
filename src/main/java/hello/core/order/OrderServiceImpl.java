package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    // 会員情報参照
     private MemberRepository memberRepository;
    //　割引情報参照
     private DiscountPolicy discountPolicy;
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
    // setter 주입
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){ // SpringContatainer에서 MemberRepository 꺼내서 주입
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }

    // DiscountPolicy discountPolicy = new FixDiscount(); -> DIP, OCP違反
    // DIP Plaes depend on only InterFace
    // OCP When occurs Changes Client Code Change No! -> DiscountPolicy discountPolicy; but NullPointException
    // 누군가는 discountPolicy 인터페이스에 구현체를 넣어줘야함 -> 스프링 컨테이너의 Autowired / final ~ 로 넣어주는 이유가 여기에 있다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // なぜメンバーを探せないのだろう
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
    // Test용 memberRepository조회코드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
