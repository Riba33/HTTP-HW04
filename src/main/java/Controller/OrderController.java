package Controller;

import Model.ApiResponse;
import Model.Order;
import Service.StoreService;
import lombok.SneakyThrows;

import java.util.Map;

public class OrderController extends BaseController{
    public static OrderController orderController;

    @SneakyThrows
    public static synchronized OrderController getInstance() {
        if (orderController == null) {
            orderController = new OrderController();
        }
        return orderController;
    }
    public void orderMenu(){
        System.out.println("Select query.\n" +
                "1 - Get inventory.\n" +
                "2 - Add order.\n" +
                "3 - Find order by Id.\n" +
                "4 - Delete order.\n" +
                "0 - Return to previous menu.");
        int i = selectNumber(4, 0);
        switchSelected(i);
    }
    void switchSelected(int i){
        switch (i) {
            case 1:
                Map<String,Integer> inventory = StoreService.getInstance().getInventory();
                System.out.println(inventory);
                break;
            case 2:
                Order order = OrderAdd.getInstance().orderAdd();
                System.out.println(order);
                break;
            case 3:
                Order order1 = OrderFindById.getInstance().findOrderById();
                System.out.println(order1);
                break;
            case 4:
                ApiResponse apiResponse = OrderDeleteById.getInstance().deleteOrderById();
                System.out.println(apiResponse);
                break;
            case 0:
                Console.getInstance().start();
                break;
        }
    }
}
