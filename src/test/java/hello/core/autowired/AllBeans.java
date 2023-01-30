package hello.core.autowired;

import hello.core.Config;
import hello.core.autoconfiguration.AutoConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeans {
    // 오늘 배운 것 정리.
    // 1. 잘 모르겠을 때는 getBeanDefinitionNames로 루프 돌려봐라
    // 2. 소문자로 저장되는 것이 맞다. (@ComponenteScan시!)
    // 3. Primary 사용을 잘 하면 두 개 이상의 동일한 타입의 빈이 있어도 해결 가능하다.
    @Test
    public void getAllBeans(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class,DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        // getBean 은 Object를 반환하기도 하고 <T> 제네릭타입의 인스턴스를 반환하기도 한다. 왜 이름으로 찾으면 안될까?

        // 왜 나는 소문자로 빈 정의 이름이 등록된다고 생각하고 있던 것이지?

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames) {
            System.out.println("beanName = " + beanName);
        }

        System.out.println(discountService.policies);
        System.out.println(discountService.policyMap);
        Member member = new Member(1L, "伊藤", Grade.VIP);

        int price = discountService.discount(member, 20000, "fixDiscountPolicy");
        System.out.println("price = " + price);

        Assertions.assertThat(price).isEqualTo(1000);


    }

    static class DiscountService {
        private final Map<String,DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
        }

        int discount(Member member, int price, String discountType){
            DiscountPolicy policy = policyMap.get(discountType);
            return policy.discount(member,price);
        }

    }
}
