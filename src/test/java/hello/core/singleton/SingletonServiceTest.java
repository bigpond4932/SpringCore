package hello.core.singleton;

import hello.core.Config;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SingletonServiceTest {
    
    @Test
    @DisplayName("싱글톤 객체 테스트, 과연 객체는 같을까?")
    void singletonServiceTest(){

//        SingletonService instance = new SingletonService(); -> .SingletonService'에서 private 액세스를 가집니다! new 불가능
//        instance.logic();
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        // 두 객체는 같을까요?
        Assertions.assertThat(instance1).isSameAs(instance2);
    }
    @Test
    @DisplayName("단점이 많은 싱글톤패턴 과연 스프링 컨테이너는 이 문제를 해결할 수 있을까?")
    void springContainer(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        MemberService instance1 = ac.getBean(MemberService.class);
        MemberService instance2 = ac.getBean(MemberService.class);

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        Assertions.assertThat(instance1).isSameAs(instance2);


    }
}
