package com.gsoft.univer.repository;

import com.gsoft.univer.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Integer> {

}
