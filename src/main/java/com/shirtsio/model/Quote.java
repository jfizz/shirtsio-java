package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;

public class Quote {

    @JsonProperty("print_type")
    private String printType;
    private BigDecimal discount;
    private String[] warnings;
    private BigDecimal total;
    @JsonProperty("shipping_price")
    private BigDecimal shippingPrice;
    private BigDecimal subtotal;
    @JsonProperty("sales_tax")
    private BigDecimal salesTax;
    @JsonProperty("garment_breakdown")
    private GarmentBreakdown[] garmentBreakdowns;

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public GarmentBreakdown[] getGarmentBreakdowns() {
        return garmentBreakdowns;
    }

    public void setGarmentBreakdowns(GarmentBreakdown[] garmentBreakdowns) {
        this.garmentBreakdowns = garmentBreakdowns;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String[] getWarnings() {
        return warnings;
    }

    public void setWarnings(String[] warnings) {
        this.warnings = warnings;
    }
}


class GarmentBreakdown {
    @JsonProperty("price_per_shirt")
    private BigDecimal pricePerShirt;
    @JsonProperty("num_shirts")
    private int numShirts;
    private BigDecimal subtotal;

    public int getNumShirts() {
        return numShirts;
    }

    public void setNumShirts(int numShirts) {
        this.numShirts = numShirts;
    }

    public BigDecimal getPricePerShirt() {
        return pricePerShirt;
    }

    public void setPricePerShirt(BigDecimal pricePerShirt) {
        this.pricePerShirt = pricePerShirt;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}