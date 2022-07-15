package kg.attractor.java;

 import kg.attractor.java.homework.RestaurantOrders;

 import kg.attractor.java.homework.domain.Order;

 import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Order> orders = RestaurantOrders.read("orders_1000.json").getOrders();

//        RestaurantOrders.print(orders);
//        Order.OrdersGreatestSum();
//        System.out.println(Order.OrderMinSum(orders));
        System.out.println(Order.OrderMaxSum(orders));
//        Order.lowOrderPrice(orders);












    }
}
