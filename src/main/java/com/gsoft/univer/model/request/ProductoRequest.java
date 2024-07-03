package com.gsoft.univer.model.request;

public class ProductoRequest {
    private String name;
    private String sku;
    private int cantidad;

    public ProductoRequest() {
    }

    public ProductoRequest(String name, String sku, int cantidad) {
        this.name = name;
        this.sku = sku;
        this.cantidad = cantidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

