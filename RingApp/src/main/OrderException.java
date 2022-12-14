package main;

public class OrderException extends Exception{
    static final long serialVersionUID = 1L;

    public OrderException(String s) {
        System.out.println("Exception is: " + s);
    }
}
