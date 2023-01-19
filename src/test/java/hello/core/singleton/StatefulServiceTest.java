package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    @DisplayName("Stateful 싱글톤 객체의 무서움")
    void statefulService(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);
        // 1번손님 주문
        service1.order("홍용택", 30000);
        // 2번손님 주문
        service2.order("장세준", 20000);

        // 1번 손님이 주문한 오더니까 30000원이겠네?
        int price = service1.getPrice();

        // 어라? 2만 원이네?
        System.out.println("price = " + price);

        Assertions.assertThat(service1.getPrice()).isNotEqualTo(30000);

    }




    static class TestConfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}


