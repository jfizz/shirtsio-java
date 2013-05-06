package com.shirtsio;


import com.shirtsio.model.Category;
import com.shirtsio.model.DetailedProduct;
import com.shirtsio.model.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * All methods throw RestClientException, api user may have to deal with this.
 */
public class ProductManager {
    private String category_url = "products/category/";
    private ApiTemplate apiTemplate = new ApiTemplate();

    public Category[] getCategories() {
        return apiTemplate.getObjects(category_url, Category.class);
    }

    public Product[] getProductsBy(long categoryId) {
        return apiTemplate.getObjects(category_url + categoryId + "/", Product.class);
    }

    public DetailedProduct getProduct(long productId) {
        return apiTemplate.getObject("products/" + productId + "/", DetailedProduct.class, null);
    }

    public Map<String, Long> getInventoryCount(long productId, String color, String state) {
        Map<String, String> params = new HashMap<String, String>();
        if(color != null) {
            params.put("color", color);
        }
        if(state != null) {
            params.put("state", state);
        }

        DetailedProduct detailedProduct =
                apiTemplate.getProductResult("products/" + productId + "/", params);

        return detailedProduct.getInventoryCount();
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        System.out.println(manager.getCategories().length);
        System.out.println(manager.getProductsBy(1));
        System.out.println(manager.getInventoryCount(3, "White", "CA"));
        System.out.println(manager.getProduct(30));
    }
}
