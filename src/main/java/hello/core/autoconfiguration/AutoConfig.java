package hello.core.autoconfiguration;


import hello.core.Config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // ComponenteScan은 @Configuration 도 스프링 빈으로 등록하기 때문에 Config.class도 모두 빈으로 등록해버린다.
        // 따라서 Configuration 컴포넌트 스캔 대상에서 제외한다.
//        [excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class),
//        basePackages = "core"
        // ※ ComponentScan은 해당 어노테이션이 붙은 패키지 기준으로 Component를 탐색한다.
        // 내가 core.autoconfiguration에 AutoConfig를 두고, AutoConfig클래스로 스프링 컨테이너를 생성하면, AutoConfig만 빈으로 등록된다.
)
public class AutoConfig {
}
