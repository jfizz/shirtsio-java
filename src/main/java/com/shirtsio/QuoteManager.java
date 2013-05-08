package com.shirtsio;

import com.shirtsio.model.Quote;
import com.shirtsio.model.QuoteResponse;

import java.util.HashMap;
import java.util.Map;

public class QuoteManager extends ApiTemplate {

    private String quoteUrl = "quote";
    public Quote getQuote(Map<String, Object> params) {
        return get(quoteUrl, QuoteResponse.class, params).getResult();
    }

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("garment[0][product_id]", 3);
        params.put("garment[0][color]", "White");
        params.put("garment[0][sizes][med]", 100);
        params.put("print[front][color_count]", 5);

        System.out.println(new QuoteManager().getQuote(params).getDiscount());
    }
}
