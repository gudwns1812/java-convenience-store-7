package store.view;

import java.util.Map;
import java.util.Map.Entry;
import store.domain.Product;

public class OutputView {
    private static final String PRINT_INFORMATION = "안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printInformation() {
        System.out.println(PRINT_INFORMATION);
    }

    public static void printPrompt(String message) {
        System.out.println(message);
    }

    public static void printError(String error) {
        System.out.println(ERROR_PREFIX + error);
    }

    public static void printProducts(Map<Product, Integer> products) {
        for (Entry<Product, Integer> entry : products.entrySet()) {
            System.out.println(
                    "- " + entry.getKey().getName() + " " + entry.getKey().getPrice() + "원 " + entry.getValue() + "개");
        }
    }
}
