package Controller;

import Model.Order;
import Service.StoreService;
import lombok.SneakyThrows;

public class OrderFindById extends OrderAdd{
    public static OrderFindById orderController;

    @SneakyThrows
    public static synchronized OrderFindById getInstance() {
        if (orderController == null) {
            orderController = new OrderFindById();
        }
        return orderController;
    }
    public Order findOrderById(){
        Long id = getAndCheckOrderId();
        return StoreService.getInstance().getOrderById(id);
    }

}
