package com.gsoft.univer.model.response;

public class ProductoResponse {
    private String name;
    private String sku;
    private int cantidad;
    private Notificacion notificacion;

    public ProductoResponse() {
    }

    public ProductoResponse(String name, String sku, int cantidad) {
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

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }
}
