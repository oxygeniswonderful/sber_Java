import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

public class DispatcherClass implements Dispatcher {

    private final ArrayBlockingQueue<Taxi> queueTaxi;
    private Taxi currentTaxi;

    public DispatcherClass(int amountTaxi) {
        this.queueTaxi = new ArrayBlockingQueue<>(amountTaxi);
    }

    @Override
    public synchronized void notifyAvailable(Taxi taxi) {

        queueTaxi.add(taxi);


    }

    @Override
    public void run() {

        while (true) {

           Order order = new Order(0, 1000);
            currentTaxi = null;
           try {
               currentTaxi = queueTaxi.take();
           } catch (InterruptedException ignored) {
           }
           System.out.println("Dispatcher " + Thread.currentThread().getName() + " new order " + order.timeOrder);
           synchronized (currentTaxi) {
               currentTaxi.placeOrder(order);
               queueTaxi.remove(currentTaxi);
               currentTaxi.notify();

           }

        }
    }
}
