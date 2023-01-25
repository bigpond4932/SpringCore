package hello.core.autoconfiguration;


import hello.core.Config;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        // ComponenteScan은 @Configuration 도 스프링 빈으로 등록하기 때문에 Config.class도 모두 빈으로 등록해버린다.
        // 따라서 Configuration 컴포넌트 스캔 대상에서 제외한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)

        // ※ ComponentScan은 해당 어노테이션이 붙은 패키지 기준으로 Component를 탐색한다.
        // 내가 core.autoconfiguration에 AutoConfig를 두고, AutoConfig클래스로 스프링 컨테이너를 생성하면, AutoConfig만 빈으로 등록된다.
)
public class AutoConfig {

//    Bean의 자동등록 수동등록
//    수동등록이 우선권을 가져 수동등록빈이 오버라이딩 되나,
//    Overriding bean definition for bean 'memoryMemberRepository' with a different definition: replacing [Generic bean: class [hello.core.member.MemoryMemberRepository]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in file
//
//    스프링부트를 사용하게 되면 디폴트 값은 false로 이름이 같은 빈은 등록될 수 없다.
//    BeanDefinitionOverrideException
//    The bean 'memoryMemberRepository', defined in class path resource [hello/core/autoconfiguration/AutoConfig.class], could not be registered. A bean with that name has already been defined in file [C:\workSpace\SpringCore\out\production\classes\hello\core\member\MemoryMemberRepository.class] and overriding is disabled.
//
//    ErrorCode
//            구성
//    Discription!
//
//    Action!
//    오류 읽어보면 답이 나온다.
//
//    중요 : 코딩은 혼자하는 것이 아니기 때문에, 애매한 것 같다 싶으면 안 쓰는게 쓰는 것보다 낫다.
//    @Bean("memoryMemberRepository")
//    MemoryMemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
