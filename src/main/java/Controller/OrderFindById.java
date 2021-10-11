package Controller;

import Model.Order;
import Service.StoreService;
import lombok.SneakyThrows;

public class OrderFindById extends BaseController{
    public static OrderFindById orderController;

    @SneakyThrows
    public static synchronized OrderFindById getInstance() {
        if (orderController == null) {
            orderController = new OrderFindById();
        }
        return orderController;
    }
    public Order findOrderById(){
        System.out.println("Enter orderId");
        Long id = getId();
        return StoreService.getInstance().getOrderById(id);
    }

}
