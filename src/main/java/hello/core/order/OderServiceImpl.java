package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OderServiceImpl implements OrderService{
    // 会員情報参照
    MemberRepository memberRepository = new MemoryMemberRepository();
    //　割引情報参照
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // なぜメンバーを探せないのだろう
        int discountPrice = discountPolicy.discount(member);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

}
