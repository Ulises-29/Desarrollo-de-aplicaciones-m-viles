package com.gsoft.univer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTO")
public class ProductoEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "NAME")
    private String nombre;

    @Column()
    private int cantidad;


    @Column(name = "SKU")
    private String sku;

    public ProductoEntity() {
    }

    public ProductoEntity(String nombre, int cantidad, String sku) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.sku = sku;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
