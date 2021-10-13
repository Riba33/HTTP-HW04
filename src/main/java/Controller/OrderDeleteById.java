package Controller;

import Model.ApiResponse;
import Service.StoreService;
import lombok.SneakyThrows;

public class OrderDeleteById extends OrderAdd{
    public static OrderDeleteById orderController;

    @SneakyThrows
    public static synchronized OrderDeleteById getInstance() {
        if (orderController == null) {
            orderController = new OrderDeleteById();
        }
        return orderController;
    }
    public ApiResponse deleteOrderById(){
        Long id = getAndCheckOrderId();
        return StoreService.getInstance().deleteOrderById(id);
    }
}
