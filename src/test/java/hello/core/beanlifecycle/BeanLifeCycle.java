package hello.core.beanlifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycle {

    @Test
    public void LifeCycle(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        NetworkClient networkClient = ac.getBean(NetworkClient.class);
        System.out.println("networkClient = " + networkClient);
        System.out.println(networkClient.getUrl());
        ac.close(); // 스프링 컨테이너를 종료

    }

    @Configuration
    static class Config{

//        @Bean(initMethod = "init", destroyMethod = "destroy")
        @Bean
        public NetworkClient networkClient(){
            NetworkClient client = new NetworkClient(); // 객체 생성
            client.setUrl("http://hello-spring.dev"); // url 초기화
            return client; // 객체 리턴
        }
    }
}
