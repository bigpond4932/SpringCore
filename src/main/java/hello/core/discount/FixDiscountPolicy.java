package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    final int discountFixPrice = 1000;
    @Override
    public int discount(Member member) {
        if(member.getGrade()== Grade.VIP){
            return discountFixPrice ;
        }else {
            return 0;
        }
    }
}