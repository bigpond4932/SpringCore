package hello.core.findbeans;

import hello.core.Config;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextFindBeans {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName(){
        MemberService bean = ac.getBean("memberService", MemberService.class);
        assertThat(bean).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService bean = ac.getBean(MemberService.class);
        assertThat(bean).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByImplType(){
        MemberService bean = ac.getBean("memberService",MemberServiceImpl.class);
        assertThat(bean).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("객체가 없을 때 테스트 실패")
    void findBeanNameFailed(){
        // MemberService bean = ac.getBean("xxxxxx", MemberServiceImpl.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxxx", MemberServiceImpl.class));
    }
}
