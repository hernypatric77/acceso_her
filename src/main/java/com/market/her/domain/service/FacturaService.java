package com.market.her.domain.service;

import com.market.her.domain.dto.FacturaRequest;
import com.market.her.domain.dto.FacturaResponse;
import com.market.her.persistence.entity.Factura;

import java.util.Optional;

public interface FacturaService {

    public  Iterable<Factura> findAll();
    public  Iterable<FacturaResponse> findEstado();
    public Optional<Factura> findById(Long id);
    public FacturaResponse save(FacturaRequest factura);
    public FacturaResponse edit(FacturaRequest factura, Optional<Factura> o);
    public void deleteById(Long id);
}
