package hello.core.singleton;

public class StatefulService {

    private int price;

    public String order(String name, int price){
        this.price = price;
        return "name : " +name + "price : "+price;
    }

    public int getPrice(){
        return price;
    }
}
