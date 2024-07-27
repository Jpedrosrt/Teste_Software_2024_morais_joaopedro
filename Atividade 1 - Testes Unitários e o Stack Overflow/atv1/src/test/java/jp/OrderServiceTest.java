package jp;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OrderServiceTest {

    @Test
    public void testPlaceOrder() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder(100.0);

        assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlaceOrderWithFailure() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        // This will cause the PaymentService to throw an exception
        orderService.placeOrder(-100.0);

    }
    
}

