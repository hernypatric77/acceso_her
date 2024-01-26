package com.market.her.persistence.crud;


import com.market.her.domain.dto.FacturaResponse;
import com.market.her.persistence.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Long> {

    public Iterable<Factura> findByEstado(String estado);

}
