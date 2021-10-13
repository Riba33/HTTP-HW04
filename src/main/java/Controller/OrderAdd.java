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
        order.setId(getOrderId());
        System.out.println("Enter petId");
        order.setPetId(getId());
        System.out.println("Enter quantity");
        order.setQuantity(getInt());
        scanner.nextLine();
        System.out.println("Enter shipDate");
        order.setShipDate(getShipDate());
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
    String getShipDate(){
        System.out.println("Enter year.");
        int i;
        do {
            System.out.println("The year must be 4 digits!");
            i = getInt();
        } while (!selectIsGood(i,9999,1985));
        int year = i;
        System.out.println("Enter month.");
        do {
            System.out.println("The month is from 1 to 12 !");
            i = getInt();
        } while (!selectIsGood(i,12,1));
        int month = i;
        System.out.println("Enter day.");
        do {
            System.out.println("The day is from 1 to 31 !");
            i = getInt();
        } while (!selectIsGood(i,31,1));
        int day = i;
        System.out.println("Enter hours.");
        do {
            System.out.println("The hours is from 0 to 23 !");
            i = getInt();
        } while (!selectIsGood(i,23,0));
        int hours = i;
        System.out.println("Enter minutes.");
        do {
            System.out.println("The minutes is from 0 to 59 !");
            i = getInt();
        } while (!selectIsGood(i,59,0));
        int min = i;

        return year+"-"+checkDigit(month)+"-"+checkDigit(day)+"T"
                +checkDigit(hours)+":"+checkDigit(min);
    }
    String checkDigit(int i){
        String st;
        if( i < 10) st = "0" + i;
        else st = String.valueOf(i);
        return st;
    }
    Long getOrderId(){
        long orderId;
        int i;
        do {
            System.out.println("Enter orderId. Id must be from 1 to 10 !");
            orderId = getId();
        } while(!selectLongIsGood(orderId,10,1));
        return orderId;
    }
    Long getAndCheckOrderId(){
        Order order;
        StoreService orderService = StoreService.getInstance();
        Long id;
        boolean i;
        do {
            i = false;
            id = getOrderId();
            order = orderService.getOrderById(id);
            if (order == null) {
                System.out.println("This Order is not found.\nDo you want enter another orderId?");
                i = yesOrNo();
            }
        } while (i);
        return id;
    }
    private boolean selectLongIsGood(Long id, int max, int min){
        if(id >= min && id <= max) return true;
        else return false;
    }
}
