package com.market.her.persistence.crud;


import com.market.her.persistence.entity.DetalleFactura;
import com.market.her.persistence.entity.Factura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Long> {

    List<DetalleFactura> findByFactura(Factura factura);
}
