package com.market.her.domain.service;

import com.market.her.persistence.entity.DetalleFactura;

import java.util.Optional;

public interface DetalleFacturaService {

    public  Iterable<DetalleFactura> findAll();
    public Optional<DetalleFactura> findById(Long id);
    public DetalleFactura save(DetalleFactura factura);
    public void deleteById(Long id);
}
