package com.gsoft.univer.controller;

import com.gsoft.univer.entity.ProductoEntity;
import com.gsoft.univer.model.request.ProductoRequest;
import com.gsoft.univer.model.response.Notificacion;
import com.gsoft.univer.model.response.ProductoResponse;
import com.gsoft.univer.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Notification;
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
    public ResponseEntity producutos (@PathVariable Integer id) {

//        Optional<ProductoEntity> producto = repository.findById(id);
//
//        if (producto.isPresent()){
//            return producto.get();
//        }else {
//            return null;
//        }
        Optional<ProductoEntity> productoEntity = repository.findById(id);
        if (productoEntity.isPresent()) {
            ProductoResponse response = new ProductoResponse(
                    productoEntity.get().getNombre(),
                    productoEntity.get().getSku(),
                    productoEntity.get().getCantidad()
            );
            Notificacion notification = new Notificacion();
            notification.setLevel("success");
            notification.setReason("Found");
            notification.setMessage("el pruducto que consulto es " + response.getName() );
            response.setNotificacion(notification);
            return new ResponseEntity(response, HttpStatus.OK);
        } else {
            return new ResponseEntity("No hay informacion ligada al ID", HttpStatus.NO_CONTENT);
        }

    }

    @CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
    @PostMapping("/save/product")
    public ResponseEntity save (@RequestBody ProductoRequest request) {

        HttpHeaders  responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        //responseHeaders.setAccessControlAllowOrigin("http://localhost:5173");

        ProductoEntity entity = new ProductoEntity(
                request.getName(),
                request.getCantidad(),
                request.getSku()
        );

        ProductoResponse response = new ProductoResponse();
        response.setName(entity.getNombre());

        Notificacion notification = new Notificacion();
        notification.setLevel("success");
        notification.setReason("Exitoso");
        notification.setMessage("El prodcuto " + entity.getNombre() + "se registro de manera exitoso");
        response.setNotificacion(notification);

        try {
            repository.save(entity);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    headers(responseHeaders).
                    body(response.getNotificacion());
        }

        return ResponseEntity.status(HttpStatus.CREATED).
                headers(responseHeaders).
                body(response);

    }
}
