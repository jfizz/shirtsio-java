package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class DetailedProduct extends Product {
    private ObjectMapper mapper  = new ObjectMapper();

    @JsonProperty("style_id")
    private Long styleId;

    private String brand;
    private String comments;
    private String materials;
    private String[] pictures;
    private String description;
    @JsonProperty("colors")
    private ProductColor[] productColors;
    private boolean hasSleeves = false;

    private Map<String, Long> inventoryCount;

    @JsonProperty("inventory")
    public Map<String, Long> getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Map<String, Long> inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public boolean hasSleeves() {
        return hasSleeves;
    }

    @JsonProperty("has_sleeves")
    public void setHasSleeves(int hasSleeves) {
        if(hasSleeves == 1) {
            this.hasSleeves = true;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public ProductColor[] getProductColors() {
        return productColors;
    }

    public void setProductColors(ProductColor[] productColors) {
        this.productColors = productColors;
    }

    public Long getStyleId() {
        return styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }
}

class ProductColor {
    private String name;
    private String hex;
    @JsonProperty("front_image")
    private String frontImage;
    @JsonProperty("left_image")
    private String leftImage;
    @JsonProperty("right_image")
    private String rightImage;
    @JsonProperty("back_image")
    private String backImage;
    private String smallest;
    private String largest;


    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getLargest() {
        return largest;
    }

    public void setLargest(String largest) {
        this.largest = largest;
    }

    public String getLeftImage() {
        return leftImage;
    }

    public void setLeftImage(String leftImage) {
        this.leftImage = leftImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRightImage() {
        return rightImage;
    }

    public void setRightImage(String rightImage) {
        this.rightImage = rightImage;
    }

    public String getSmallest() {
        return smallest;
    }

    public void setSmallest(String smallest) {
        this.smallest = smallest;
    }
}