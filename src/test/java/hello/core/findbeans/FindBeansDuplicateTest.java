package hello.core.findbeans;

import hello.core.Config;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class FindBeansDuplicateTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

    @Test
    @DisplayName("객체 타입이 같은 빈 객체가 중복 되었을 때!")
    void duplicate(){
//        DiscountPolicy bean = ac.getBean(DiscountPolicy.class)
        // NoUniqueBeanDefinitionException 가 일어남
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,()->ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("중복 객체 타입이 존재할 때 함께 조회 // 부모 타입으로 조회")
    void duplicateSolution(){
        // DiscountPolicy bean = ac.getBean(DiscountPolicy.class)
        // NoUniqueBeanDefinitionException 가 일어남
        // 해결책 1. 메소드 이름(Bean이름)을 붙여서 찾는다. 2. 구체클래스 타입으로 찾는다.-> 하위(자식)타입 조회 3. 전부 찾는다.
        String[] beanNamesForType = ac.getBeanNamesForType(DiscountPolicy.class);
        for (String beanName : beanNamesForType) {
            System.out.println("beanName = " + beanName);
        }

        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key+ " Name = "+beansOfType.get(key));
        }
    }


    @Configuration
    static class Config{

        @Bean
        public DiscountPolicy discountPolicy1(){
          return new FixDiscountPolicy();
        }
        @Bean
        public DiscountPolicy discountPolicy2(){
            return  new RateDiscountPolicy();
        }

    }
}
