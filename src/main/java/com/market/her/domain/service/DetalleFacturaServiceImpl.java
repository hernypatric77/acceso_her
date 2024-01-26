package com.market.her.domain.service;

import com.market.her.persistence.crud.DetalleFacturaRepository;
import com.market.her.persistence.crud.FacturaRepository;
import com.market.her.persistence.entity.DetalleFactura;
import com.market.her.persistence.entity.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository repository;
    @Override
    @Transactional(readOnly = true)
    public Iterable<DetalleFactura> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DetalleFactura> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public DetalleFactura save(DetalleFactura detalleFactura) {
        return repository.save(detalleFactura);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
