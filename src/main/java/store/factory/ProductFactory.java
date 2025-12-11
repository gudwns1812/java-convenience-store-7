package store.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductFactory {
    private static final String PRODUCT_DELIMITER = ",";
    private static final String ORDER_START = "[";
    private static final String ORDER_END = "]";
    private static final int ORDER_PREFIX_SIZE = 1;
    private static final String ORDER_DELIMITER = "-";
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_COUNT_INDEX = 1;

    public static Map<String, Integer> createOrder(String inputProducts) {
        List<String> inputOrders = List.of(inputProducts.split(PRODUCT_DELIMITER));
        validateOrders(inputOrders);

        Map<String, Integer> orders = new HashMap<>();

        for (String inputOrder : inputOrders) {
            String order = deleteOrderPrefixAndSuffix(inputOrder);

            String[] product = order.split(ORDER_DELIMITER);
            String productName = product[PRODUCT_NAME_INDEX];
            String productCount = product[PRODUCT_COUNT_INDEX];

            validateNumber(productCount);
            Integer count = Integer.valueOf(productCount);

            orders.put(productName, count);
        }
        return orders;
    }

    private static void validateOrders(List<String> inputOrders) {
        inputOrders.forEach(order -> {
            if (!(order.startsWith(ORDER_START) && order.endsWith(ORDER_END))) {
                throw new IllegalArgumentException("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");
            }
        });
    }

    private static String deleteOrderPrefixAndSuffix(String inputOrder) {
        return inputOrder.substring(ORDER_PREFIX_SIZE, inputOrder.length() - ORDER_PREFIX_SIZE);
    }

    private static void validateNumber(String productName) {
        try {
            Integer.parseInt(productName);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");
        }
    }
}
