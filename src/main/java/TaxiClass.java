public class TaxiClass implements Taxi {

    public volatile Order order;
    public final Dispatcher dispatcher;
    public String condition;


    public TaxiClass(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;

    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                while (this.condition != null) {
                    sleeping();
                    System.out.println("Taxi " + Thread.currentThread().getName() + " waiting the order");
                    order = null;
                    dispatcher.notifyAvailable(this);
                    try {
                        this.wait();
                    } catch (InterruptedException ignored) {
                    }
                }

            }
        }
    }


    public synchronized void sleeping() {
        System.out.println("Taxi " + Thread.currentThread().getName() + " completing the order");
        try {
            Thread.sleep(order.timeOrder);
        } catch (InterruptedException ignored) {
        }
        order = null;
        dispatcher.notifyAvailable(this);
    }

    @Override
    public synchronized void placeOrder(Order order) {
        this.order = order;
        this.condition = "new order";

    }
}
