package jp;

public class PaymentService {
    public boolean processPayment(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative");
        }
        return true;
    }

}
