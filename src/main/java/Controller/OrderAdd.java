package Controller;

import Model.Order;
import Model.OrderStatus;
import Service.StoreService;
import lombok.SneakyThrows;

public class OrderAdd extends BaseController{
    public static OrderAdd orderController;

    @SneakyThrows
    public static synchronized OrderAdd getInstance() {
        if (orderController == null) {
            orderController = new OrderAdd();
        }
        return orderController;
    }
    public Order orderAdd(){
        Order order = makeOrder();
        return StoreService.getInstance().addOder(order);
    }
    Order makeOrder(){
        Order order = new Order();
        System.out.println("Enter orderId");
        order.setId(getId());
        System.out.println("Enter petId");
        order.setPetId(getId());
        System.out.println("Enter quantity");
        order.setQuantity(getInt());
        System.out.println("Enter shipDate");
        order.setShipDate(scanner.nextLine());
        System.out.println("Enter status");
        order.setStatus(getStatus());
        System.out.println("Enter complete.");
        order.setComplete(yesOrNo());
        return order;
    }
    OrderStatus getStatus(){
        OrderStatus status = null;
        System.out.println("Select orderStatus. 1 - placed, 2 - approved, 3 - delivered.");
        int i = selectNumber(3,1);
        switch (i) {
            case 1:
                status = OrderStatus.placed;
                break;
            case 2:
                status = OrderStatus.approved;
                break;
            case 3:
                status = OrderStatus.delivered;
                break;
        }
        return status;
    }
}
