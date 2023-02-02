package hello.core.beanlifecycle;

//import org.springframework.beans.factory.DisposableBean; Spring에 의존해서 빈 초기화, 소멸 시점을 파악하는 것은 라이브러리를 사용할 떄 문제가 될 수 있다.
//import org.springframework.beans.factory.InitializingBean;

import org.junit.jupiter.api.Test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public NetworkClient(){
        System.out.println("생성자 호출 : "+ url);

    }

    public void connect(){
        System.out.println("connect : " +url);
    }

    public void call(String message){
        System.out.println("call : "+url + " message : "+ message);
    }
    public void disconnect(){
        System.out.println("close : " + url);
    }
    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("call destroy");
        disconnect();
    }
    @PostConstruct
    public void init() throws Exception {
        System.out.println("call init");
        connect();
        call("초기화 연결 메시지");
    }
}
