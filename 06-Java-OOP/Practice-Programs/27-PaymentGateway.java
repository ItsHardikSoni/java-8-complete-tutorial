interface GatewayPayment {
    boolean process(double amount);
}

class CardGateway implements GatewayPayment {
    public boolean process(double amount) {
        System.out.println("Card gateway processed " + amount);
        return true;
    }
}

class NetBankingGateway implements GatewayPayment {
    public boolean process(double amount) {
        System.out.println("Net banking gateway processed " + amount);
        return true;
    }
}

class PaymentGateway {
    public static void main(String[] args) {
        GatewayPayment payment;
        payment = new CardGateway();
        payment.process(2500);
        payment = new NetBankingGateway();
        payment.process(4800);
    }
}
