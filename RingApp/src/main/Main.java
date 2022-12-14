package main;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws OrderException {

//        System.out.println("Hello world!");
        MaterialType materialType = new MaterialType("Gold", "metal", 100.0);
        Customer customer = new Customer("Bob", "Luis", "511-111-111", "Warsaw");
        Jeweler jeweler = new Jeweler("David", "Cuper", "511-222-222", "Warsaw", 50.0);

        Order order = new Order(customer, jeweler,15.0, 3.0, LocalDateTime.now(), materialType);

        order.createOrder();
        order.takenOrder();
        order.calculatedTotalSum();
        order.doTransaction(50.0);
//        order.startDoOrder();
        System.out.println(order.getStatusOfOrder());



    }
}