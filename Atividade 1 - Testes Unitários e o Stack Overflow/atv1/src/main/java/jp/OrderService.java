package jp;

public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean placeOrder(double amount) {
        return paymentService.processPayment(amount);
    }
}

