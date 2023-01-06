package hello.core.order;


// オーダーを作る
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
