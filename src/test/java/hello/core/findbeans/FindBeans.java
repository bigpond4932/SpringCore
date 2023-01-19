package hello.core.findbeans;


import hello.core.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FindBeans {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

    @Test
    void findAllBeans(){
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName + " object = "+ ac.getBean(beanName));
        }
        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    void findBeans(){
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);
            if(beanDefinition.getRole() == beanDefinition.ROLE_APPLICATION)
            System.out.println("beanName = " + beanName + " object = "+ ac.getBean(beanName));
        }
    }

}
