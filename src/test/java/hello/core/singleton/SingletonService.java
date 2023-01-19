package hello.core.singleton;

public class SingletonService {
    // 어디서든 참조가능한 바뀌지 않는 단 하나의 객체
    private static final SingletonService instance = new SingletonService();

    // public 으로 참조만 할 수 있게 함.
    public static SingletonService getInstance (){
        return instance;
    }

    private SingletonService(){
    // 아무도 new 연산자로 SingletonService를 호출하지 못 해!
    }
    
    public void logic(){
        System.out.println("Sington객체의 로직 출력");
    }

}
