package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    int discountRate = 10;

    @Override
    public int discount(Member member) {
        return 0;
    }
    // これどうやるの？
//    @Override
//    public int discount(Member member) {
//
//        if(member.getGrade()== Grade.VIP){
//            itemPrice = itemPrice*(discountRate/100);
//            return itemPrice;
//        }else {
//            return itemPrice;
//        }
//    }
}
