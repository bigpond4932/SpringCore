package hello.core.autoconfiguration;


import org.springframework.aop.support.annotation.AnnotationClassFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.AnnotationFilter;

@Configuration
@ComponentScan(
        // ComponenteScan은 @Configuration 도 스프링 빈으로 등록하기 때문에 Config.class도 모두 빈으로 등록해버린다.
        // 따라서 Configuration 컴포넌트 스캔 대상에서 제외한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoConfig {
}
