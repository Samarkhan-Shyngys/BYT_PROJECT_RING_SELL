package test;

import junit.framework.TestCase;
import main.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class OrderTest extends TestCase {
    MaterialType materialGold, materialSilver;
    Order order1, order2;
    Customer customer1, customer2;
    Jeweler jeweler;

    @Before
    public void setUp(){
        materialGold =  new MaterialType("Gold", "It is a dense, " +
                "lustrous, yellow, malleable precious metal", 1000.0);
        materialSilver =  new MaterialType("Silver", "silver is nearly white, lustrous, " +
                "soft, very ductile, malleable, it is an excellent conductor of heat and electricity.", 500.0);
        customer1 = new Customer("Bob", "Craw", "156-111-222", "Warsaw");
        customer2 = new Customer("David", "Luis", "165-111-222", "Warsaw");
        jeweler = new Jeweler("John", "Dutton", "516-456-456", "Warsaw", 50.0);
        order1 = new Order(customer1, jeweler, 16.5, 5.5, LocalDateTime.now(), materialGold);
        order2 = new Order(customer2, jeweler, 16.7, 4.0, LocalDateTime.now(), materialSilver);
    }
    @Test
    public void testGetNeedSumm() throws OrderException {
        try {
            order1.calculatedTotalSum();
        }catch (OrderException e){
            System.out.println(e);
        }
        assertEquals((Double) 5550.0,order1.getNeedToPay());
    }
    @Test
    public void testCheckStatusOrder() throws OrderException {
        order1.createOrder();
        try {
            order1.takenOrder();
        }catch (OrderException e){
            System.out.println(e);
        }
        assertEquals(StatusType.NOT_PAID,order1.getStatusOfOrder());
    }

    @Test
    public void testForTransaction() throws OrderException {
        order1.createOrder();
        order1.takenOrder();
        order1.doTransaction(5000.0);
        assertEquals(StatusType.PARTLY_PAID,order1.getStatusOfOrder());
        assertEquals(5000.0,order1.getTransaction().getSum());
    }
    @Test
    public void testCheckStatusStarted() throws OrderException {
        order1.createOrder();
        order1.takenOrder();
        order1.doTransaction(5000.0);
        order1.startDoOrder();
        assertEquals(StatusType.IN_PROGRESS,order1.getStatusOfOrder());

    }



}
