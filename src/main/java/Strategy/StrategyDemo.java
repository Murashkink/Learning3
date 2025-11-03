package Strategy;

interface PaymentStrategy {
    void pay(int amount);
}


class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Оплата " + amount + " через кредитную карту");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Оплата " + amount + " через PayPal");
    }
}


class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(int amount) {
        strategy.pay(amount);
    }
}


public class StrategyDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.executePayment(100);

        context.setStrategy(new PayPalPayment());
        context.executePayment(200);
    }
}
