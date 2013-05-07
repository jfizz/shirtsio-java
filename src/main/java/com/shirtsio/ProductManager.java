package com.shirtsio;


import com.shirtsio.model.Category;
import com.shirtsio.model.DetailedProduct;
import com.shirtsio.model.Product;
import com.shirtsio.model.ProductResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * All methods throw RestClientException, api user may have to deal with this.
 */
public class ProductManager extends ApiTemplate {
    private String categoryUrl = "products/category/";

    public Category[] getCategories() {
        return getObjects(categoryUrl, Category.class);
    }

    public Product[] getProductsBy(long categoryId) {
        return getObjects(categoryUrl + categoryId + "/", Product.class);
    }

    public DetailedProduct getProduct(long productId) {
        return getObject("products/" + productId + "/", DetailedProduct.class, null);
    }

    public Map<String, Long> getInventoryCount(long productId, String color, String state) {
        Map<String, Object> params = new HashMap<String, Object>();
        if(color != null) {
            params.put("color", color);
        }
        if(state != null) {
            params.put("state", state);
        }

        return getProductResult("products/" + productId + "/", params).getInventoryCount();
    }

    public DetailedProduct getProductResult(String url, Map<String, Object> params) {
        return restTemplate.getForObject(buildRequestUrl(url, params), ProductResult.class)
                .getResult();
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        System.out.println(manager.getCategories().length);
        System.out.println(manager.getProductsBy(1));
        System.out.println(manager.getInventoryCount(3, "White", "CA"));
        System.out.println(manager.getProduct(30));
    }
}
