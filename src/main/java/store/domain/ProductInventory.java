package store.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductInventory {
    private final Map<Product, Integer> productStock;

    public ProductInventory(Map<Product, Integer> products) {
        this.productStock = products;
    }

    public void decrease(String name, Integer count) {
        List<Product> products = findProduct(name);

        int totalCount = 0;
        for (Product product : products) {
            Integer remainStock = productStock.get(product);
            totalCount += remainStock;
        }

        if (count > totalCount) {
            throw new IllegalArgumentException("재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.");
        }

        calculateStock(count, products);
    }

    private List<Product> findProduct(String name) {
        Set<Product> products = this.productStock.keySet();
        List<Product> findProduct = products.stream()
                .filter(product -> product.getName().equals(name))
                .sorted(Comparator.comparing(Product::isPromoted).reversed())
                .toList();

        if (findProduct.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 상품입니다. 다시 입력해 주세요.");
        }

        return findProduct;
    }

    private void calculateStock(Integer count, List<Product> products) {
        for (Product product : products) {
            Integer productCount = productStock.get(product);

            if (productCount > count) {
                productStock.put(product, productCount - count);
                return;
            }

            productStock.put(product, 0);
            count -= productCount;
        }
    }

    public Map<Product, Integer> getProducts() {
        return Map.copyOf(productStock);
    }
}
