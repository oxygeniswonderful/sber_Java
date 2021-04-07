public class Order {

    public final int timeOrder, lowValue, highValue;

    public Order() {
        lowValue = 0;
        highValue = 500;
        this.timeOrder = this.lowValue + (int) (Math.random() * highValue);
    }

    public Order(int lowValue, int highValue) {
        this.highValue = highValue;
        this.lowValue = lowValue;
        this.timeOrder = this.lowValue + (int) (Math.random() * highValue);
    }

}


