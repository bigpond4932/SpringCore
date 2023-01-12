package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vipは１０％割引されます！")
    void vip_O(){
        Member vip_member = new Member(1L, "VIP", Grade.VIP);
        int discontPrice = discountPolicy.discount(vip_member,10000);

        Assertions.assertEquals(1000,discontPrice);
    }
    @Test
    @DisplayName("Basic is not discountable Grade")
    void vip_X(){
        Member basic_member = new Member(1L,"Basic",Grade.Basic);
        int disCountPrice = discountPolicy.discount(basic_member,10000);

        Assertions.assertEquals(0,disCountPrice);
    }
}