package jp;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderServiceTestMock {
    @Mock
    private PaymentService paymentService;

    private OrderService orderService;
    private AutoCloseable closeable;

    @Before
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        orderService = new OrderService(paymentService);
    }

    @Test
    public void testPlaceOrderMock() {
        // Arrange
        when(paymentService.processPayment(100.0)).thenReturn(true);

        // Act
        boolean result = orderService.placeOrder(100.0);

        // Assert
        assertTrue(result);

        // Verify
        verify(paymentService).processPayment(100.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlaceOrderWithFailureMock() {
        // Arrange: Configura o mock para lançar uma exceção
        doThrow(new IllegalArgumentException("Amount must be non-negative")).when(paymentService).processPayment(-100.0);

        // Act: Chama o método a ser testado com um valor que causaria uma exceção
        orderService.placeOrder(-100.0);
    }

    @After
    public void close() throws Exception {
        closeable.close();
    }
}
