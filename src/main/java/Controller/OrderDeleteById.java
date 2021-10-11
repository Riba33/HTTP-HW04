package Controller;

import Model.ApiResponse;
import Service.StoreService;
import lombok.SneakyThrows;

public class OrderDeleteById extends BaseController{
    public static OrderDeleteById orderController;

    @SneakyThrows
    public static synchronized OrderDeleteById getInstance() {
        if (orderController == null) {
            orderController = new OrderDeleteById();
        }
        return orderController;
    }
    public ApiResponse deleteOrderById(){
        System.out.println("Enter orderId");
        Long id = getId();
        return StoreService.getInstance().deleteOrderById(id);
    }
}
