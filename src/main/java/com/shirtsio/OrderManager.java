package com.shirtsio;

import com.shirtsio.model.Order;
import com.shirtsio.model.OrderResponse;
import com.shirtsio.model.OrderStatus;
import com.shirtsio.model.OrderStatusResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class OrderManager extends ApiTemplate {

    private String placeOrderUrl = "order/";
    private String orderStatusUrl = "status/";

    public Order placeOrder(MultiValueMap<String, Object> params) {
        params.add("api_key", Shirtsio.apiKey);
        return post(placeOrderUrl, params, OrderResponse.class).getResult();
    }

    public OrderStatus getOrderStatus(Long orderId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("order_id", orderId);
        return get(orderStatusUrl, OrderStatusResponse.class, params).getResult();
    }

    public static void main(String[] args) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("Content-Type", "image");
        params.add("test", "true");
        params.add("price", "79.28");
        params.add("print[back][color_count]", "4");
        params.add("print[back][colors][0]", "101C");
        params.add("print[back][colors][1]", "107U");
        params.add("addresses[0][name]", "John Doe");
        params.add("addresses[0][address]", "123 Hope Ln.");
        params.add("addresses[0][city]", "Las Vegas");
        params.add("addresses[0][state]", "Nevada");
        params.add("addresses[0][country]", "US");
        params.add("addresses[0][zipcode]", "12345");
        params.add("addresses[0][batch]", "1");
        params.add("addresses[0][sizes][med]", "2");
        params.add("addresses[0][sizes][lrg]", "2");
        params.add("print_type", "Digital Print");
//        params.add("extra_screens", "Front");
        params.add("ship_type", "Standard");
        params.add("garment[0][product_id]", "2");
        params.add("garment[0][color]", "White");
        params.add("garment[0][sizes][med]", "2");
        params.add("garment[0][sizes][lrg]", "2");
        params.add("print[front][color_count]", "5");
        params.add("print[back][artwork]", new FileSystemResource(new File("/Users/Roland/Django/integrations/integrations/libs/shirtsio/close.png")));
        params.add("print[front][artwork]", new FileSystemResource(new File("/Users/Roland/Django/integrations/integrations/libs/shirtsio/close.png")));
        params.add("print[back][proof]", new FileSystemResource(new File("/Users/Roland/Django/integrations/integrations/libs/shirtsio/artwork_left.jpg")));
        params.add("print[front][proof]", new FileSystemResource(new File("/Users/Roland/Django/integrations/integrations/libs/shirtsio/artwork_left.jpg")));


        System.out.println(new OrderManager().placeOrder(params).getOrderId());

        new OrderManager().getOrderStatus(9999999L).getStatus();
    }
}
