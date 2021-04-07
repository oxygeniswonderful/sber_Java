public class Main {

    public static void main(String[] args) {
        int amount = 20;
        Dispatcher dispatcher = new DispatcherClass(amount);

        for(int i = 0; i < amount; i++) {

            Taxi newTaxi = new TaxiClass(dispatcher);
            Thread taxiThread = new Thread(newTaxi);
            dispatcher.notifyAvailable(newTaxi);
            taxiThread.start();

        }

        Thread dispatcherThread = new Thread(dispatcher);
        dispatcherThread.start();
    }
}
