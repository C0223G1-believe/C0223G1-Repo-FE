package com.example.coffee_shop.model.product.model;



public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String productImage;
    private TypeProduct typeProduct;

    public Product(int productID, String productName, double productPrice, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

    public Product(int productID, String productName, TypeProduct typeProduct) {
        this.productID = productID;
        this.productName = productName;

        this.typeProduct = typeProduct;
    }

    public Product(int productID, String productName, double productPrice, String productDescription, String productImage, TypeProduct typeProduct) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.typeProduct = typeProduct;
    }
    public Product( String productName, double productPrice, String productDescription, String productImage, TypeProduct typeProduct) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.typeProduct = typeProduct;
    }

    public Product(String productName, double productPrice, String productDescription, String productImage) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }
    public Product (){

    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

}
