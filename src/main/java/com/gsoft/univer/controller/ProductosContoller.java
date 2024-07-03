package com.gsoft.univer.controller;

import com.gsoft.univer.entity.ProductoEntity;
import com.gsoft.univer.model.request.ProductoRequest;
import com.gsoft.univer.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@RestController
@RequestMapping("/api/products")
public class ProductosContoller {

    @Autowired
    private ProductoRepository repository;

    @GetMapping("/producto/{id}")
    public ProductoEntity producutos (@PathVariable Integer id) {

        Optional<ProductoEntity> producto = repository.findById(id);

        if (producto.isPresent()){
            return producto.get();
        }else {
            return null;
        }
    }

    @PostMapping("/save/product")
    public ResponseEntity<String> save (@RequestBody ProductoRequest request) {
        ProductoEntity entity = new ProductoEntity(
                request.getName(),
                request.getCantidad(),
                request.getSku()
        );

        repository.save(entity);

        return ResponseEntity.ok("todo bien");

    }
}
