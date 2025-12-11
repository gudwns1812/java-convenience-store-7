package store;

import store.controller.ConvenienceController;
import store.factory.ApplicationFactory;

public class Application {
    public static void main(String[] args) {
        ApplicationFactory appFactory = new ApplicationFactory();
        ConvenienceController controller = appFactory.controller();

        controller.run();
    }
}
