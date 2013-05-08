package com.shirtsio;


import com.shirtsio.model.Category;
import com.shirtsio.model.CategoryResponse;
import com.shirtsio.model.DetailedProduct;
import com.shirtsio.model.Product;
import com.shirtsio.model.ProductResponse;
import com.shirtsio.model.ProductsResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * All methods throw RestClientException, api user may have to deal with this.
 */
public class ProductManager extends ApiTemplate {
    private String categoryUrl = "products/category/";

    public Category[] getCategories() {
        return get(categoryUrl, CategoryResponse.class, null).getResult();
    }

    public Product[] getProductsBy(long categoryId) {
        return get(categoryUrl + categoryId + "/", ProductsResponse.class, null)
                    .getResult();
    }

    public DetailedProduct getProduct(long productId) {
        return get("products/" + productId + "/", ProductResponse.class, null).getResult();
    }

    public Map<String, Long> getInventoryCount(long productId, String color, String state) {
        Map<String, Object> params = new HashMap<String, Object>();
        if(color != null) {
            params.put("color", color);
        }
        if(state != null) {
            params.put("state", state);
        }

        return get("products/" + productId + "/", ProductResponse.class, params)
                    .getResult().getInventoryCount();
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
//        System.out.println(manager.getCategories().length);
//        System.out.println(manager.getProductsBy(1));
        // todo
//        System.out.println(manager.getInventoryCount(3, "White", "CA"));
        System.out.println(manager.getProduct(300));
    }
}
