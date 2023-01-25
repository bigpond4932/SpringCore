package hello.core.optional;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class NullHandle {

    @Test
    void Nullable(){
        ApplicationContext ac  = new AnnotationConfigApplicationContext(Config.class);
    }


    static class Config{
//        @Bean
//        public Member member(){
//            return new Member(1L, "hong", Grade.VIP);
//        }

        @Autowired(required = false)
        public void null_object1(Member bean1){
            System.out.println("bean1 = " + bean1);
        }
        @Autowired
        public void null_object2(@Nullable Member bean2){
            System.out.println("bean2 = " + bean2);
        }
        @Autowired
        public void null_object3(Optional<Member> bean3){
            System.out.println("bean3 = " + bean3);
        }
    }
}
