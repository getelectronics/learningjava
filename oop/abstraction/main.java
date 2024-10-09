// Abstract class for Payment
abstract class Payment {
    public abstract void makePayment(double amount);

    public void transactionCompleted() {
        System.out.println("Transaction completed.");
    }
}

// Subclass for CreditCard payment
class CreditCardPayment extends Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
    }
}

// Subclass for PayPal payment
class PayPalPayment extends Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment();
        creditCard.makePayment(100.0);  // Output: Processing Credit Card payment of $100.0
        creditCard.transactionCompleted();  // Output: Transaction completed.

        Payment payPal = new PayPalPayment();
        payPal.makePayment(200.0);  // Output: Processing PayPal payment of $200.0
        payPal.transactionCompleted();  // Output: Transaction completed.
    }
}