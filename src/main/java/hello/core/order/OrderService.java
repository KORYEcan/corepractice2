package hello.core.order;

public interface OrderService {
  Order createOrder(Long memmberId, String itemName, int itemPrice);

}
