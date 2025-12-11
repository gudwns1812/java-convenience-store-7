package store.controller;

import static store.controller.printMessage.INPUT_CONTINUE;
import static store.view.OutputView.printInformation;
import static store.view.OutputView.printProducts;
import static store.view.OutputView.printPrompt;

import java.util.function.Supplier;
import store.domain.Cashier;
import store.view.InputView;
import store.view.OutputView;

public class ConvenienceController {
    private final Cashier cashier;

    public ConvenienceController(Cashier cashier) {
        this.cashier = cashier;
    }

    public void run() {
        while (true) {
            printInformation();

            printProducts(cashier.getProducts());

            printPrompt(INPUT_CONTINUE);
            String isContinue = InputView.readContinue();
            if (isContinue.equals("N")) {
                break;
            }
        }
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
