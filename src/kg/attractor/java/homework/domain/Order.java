package kg.attractor.java.homework.domain;

import kg.attractor.java.homework.RestaurantOrders;

import java.util.*;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.mapping;

public class Order {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private final Customer customer;
    private final List<Item> items;
    private final boolean homeDelivery;
    private transient double total = 0.0d;


    public Order(Customer customer, List<Item> orderedItems, boolean homeDelivery) {
        this.customer = customer;
        this.items = List.copyOf(orderedItems);
        this.homeDelivery = homeDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return homeDelivery == order.homeDelivery &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, homeDelivery);
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isHomeDelivery() {
        return homeDelivery;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }


    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", items=" + items +
                ", homeDelivery=" + homeDelivery +
                ", total=" + total +
                '}';
    }

    public void print() {
        System.out.println(customer);
        System.out.println(items);
        System.out.println(homeDelivery);
        System.out.println(total);
    }

    public void calculateTotal() {
        total = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getAmount())
                .sum();
//        System.out.println(total);
    }

    public static void OrdersGreatestSum() {
        List<Order> orders = RestaurantOrders.read("orders_1000.json").getOrders();
        var maxOrderTotal = orders.stream()
                .filter(e -> e.getItems().size() == 10)
                .max(Comparator.comparing(Order::getTotal));
        System.out.println(maxOrderTotal);
    }

    public static Order OrderMaxSum(List<Order> orders) {
        return orders.stream()
                .max(comparingDouble(Order::getTotal)).get();
    }

    public static Order OrderMinSum(List<Order> orders) {
        return orders.stream()
                .min(comparingDouble(Order::getTotal)).get();
    }

    public void ordersInHome(List<Order> orders) {
        var homeDelivery = orders.stream()
                .filter(e -> isHomeDelivery()).toList();
        homeDelivery.forEach(System.out::println);
    }

    public static List<Order> minAndMax(List<Order> orders) {
        return orders.stream()
                .sorted(comparingDouble(Order::getTotal))
                .dropWhile(m -> m.getTotal() < OrderMinSum(orders).getTotal())
                .takeWhile(m -> m.getTotal() < OrderMaxSum(orders).getTotal())
                .collect(toList());

    }

    public void lowOrderPrice(List<Order> orders) {
        var lowOrderPrice = orders.stream()                            // общая стоимость всех заказов
                .mapToDouble(e -> e.getTotal())
                .sum();
    }
}

//    public static void uniqCustomersMail (List<Order> orders){
//        var uniqCustomersMail = orders.stream()  //            адреса электронной почты
//                .flatMap(order -> order.getItems().stream())
//                .map(Customer::getEmail)
//                .collect (toSet());
//        uniqCustomersMail.forEach(System.out::println);
//}











































