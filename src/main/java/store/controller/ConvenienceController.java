package store.controller;

import static store.controller.printMessage.INPUT_CONTINUE;
import static store.controller.printMessage.INPUT_PRODUCT;
import static store.view.InputView.readContinue;
import static store.view.InputView.readProductAndCount;
import static store.view.OutputView.printError;
import static store.view.OutputView.printInformation;
import static store.view.OutputView.printProducts;
import static store.view.OutputView.printPrompt;

import java.util.Map;
import java.util.function.Supplier;
import store.domain.Cashier;
import store.factory.ProductFactory;

public class ConvenienceController {
    private final Cashier cashier;

    public ConvenienceController(Cashier cashier) {
        this.cashier = cashier;
    }

    public void run() {
        while (true) {
            printInformation();

            printProducts(cashier.getProducts());

            Map<String, Integer> orders = getOrders();
            cashier.handleOrder(orders);

            printPrompt(INPUT_CONTINUE);
            String isContinue = readContinue();
            if (isContinue.equals("N")) {
                break;
            }
        }
    }

    private Map<String, Integer> getOrders() {
        return retryOnError(() -> {
            printPrompt(INPUT_PRODUCT);
            String inputProduct = readProductAndCount();
            return ProductFactory.createOrder(inputProduct);
        });
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }
}
