package christmas;

public class Application {
    public static void main(String[] args) {
        Shop shop = new Shop(new BenefitHistoryGenerator());
        shop.serveCustomer();
    }
}
