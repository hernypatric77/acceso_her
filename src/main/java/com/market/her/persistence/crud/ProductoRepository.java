package com.market.her.persistence.crud;


import com.market.her.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
