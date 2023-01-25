package hello.core.annotationtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void test(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        ac.getBean("componentA",ComponentA.class);

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()-> ac.getBean("componentB"));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  MyExcludeComponent.class)
    )
    static class AppConfig{
    }
}
