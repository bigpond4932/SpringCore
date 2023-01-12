package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OderServiceImpl implements OrderService{
    // 会員情報参照
    MemberRepository memberRepository;
    //　割引情報参照
    DiscountPolicy discountPolicy;

    public OderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
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

}
