package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    // 割引をどんな方法ですろか、定額か、レートか
    int discount(Member member);
}
