package hello.core.autoconfigtest;

import hello.core.autoconfiguration.AutoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoConfigTest {

    @Test
    @DisplayName("AutoConfig가 잘 작동할까?")
    void autoConfigTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanName : beanDefinitionNames){
            String className = beanName;
            System.out.println("className = " + className);
        }

//        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        memberService.toString();
//        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);


    }
}
