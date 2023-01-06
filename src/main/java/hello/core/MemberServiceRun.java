package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OderServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;

import java.util.Arrays;

public class MemberServiceRun {
    public static void main(String[] args) {
        // MemberSerViceImplとOrderServiceが参照するMemberRepositoryが違うためNullがずっと出てくる
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OderServiceImpl();



        Member member = new Member(1L, "Hong", Grade.VIP);
        // 加入
        memberService.join(member);
        System.out.println(memberService.findMember(1L).getName());
        // HONG -> もうレポジトリに1LのHONGが存在

        // given
        // CLient Hongがオーダーを作る　⇒　Price30000の棚を注文する、⇒　Sercviceの役目「会員参照」、「割引制作参照」⇒オーダーを作る

        // when
        Order order = orderService.createOrder(1L,"Shelf",30000);

        //　orderService　memberServiceが参照するstoreが違ったため、findByIdをしても　Nullしか出なかった。同じstoreを参照させるため
        //　Store変数にStaticを加え、インスタンスたちに共有できるようにした。

        // then
        System.out.println("order : "+ order);
        System.out.println("disCountedPrice = " + order.calculatePrice());

    }
}