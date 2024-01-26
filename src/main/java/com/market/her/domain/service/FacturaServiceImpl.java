package com.market.her.domain.service;

import com.market.her.domain.dto.FacturaRequest;
import com.market.her.domain.dto.FacturaResponse;
import com.market.her.persistence.crud.ClienteRepository;
import com.market.her.persistence.crud.FacturaRepository;
import com.market.her.persistence.entity.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaRepository repository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    @Transactional(readOnly = true)
    public Iterable<Factura> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<FacturaResponse> findEstado() {
        List<FacturaResponse> listFacturaDto = new ArrayList<FacturaResponse>();
        Iterable<Factura> facturas = repository.findByEstado("A");
        facturas.forEach(factura -> {
            FacturaResponse facResp = new FacturaResponse();
            facResp.setId(factura.getId());
            facResp.setEstado(factura.getEstado());
            facResp.setNumeroFactura(factura.getNumeroFactura());
            facResp.setFecha(factura.getCreateAt());
            facResp.setTotal(factura.getTotal());
            facResp.setIdCliente(factura.getCliente().getIdCliente());
            listFacturaDto.add(facResp);
        });
        return listFacturaDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Factura> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public FacturaResponse save(FacturaRequest facturaR) {
        Factura fac = new Factura();
        fac.setNumeroFactura(facturaR.getNumeroFactura());
        fac.setTotal(facturaR.getTotal());
        fac.setEstado(facturaR.getEstado());
        fac.setCliente(clienteRepository.findById(facturaR.getIdCliente()).get());
        Factura fbd = repository.save(fac);
        FacturaResponse facturaResponse = new FacturaResponse();
        facturaResponse.setId(fbd.getId());
        facturaResponse.setEstado(fbd.getEstado());
        facturaResponse.setNumeroFactura(fbd.getNumeroFactura());
        facturaResponse.setTotal(fbd.getTotal());
        facturaResponse.setFecha(fbd.getCreateAt());
        facturaResponse.setIdCliente(fbd.getCliente().getIdCliente());
        return facturaResponse;
    }

    @Override
    public FacturaResponse edit(FacturaRequest factura, Optional<Factura> o) {
        Factura facturaDb = o.get();
        if("I".equalsIgnoreCase(factura.getEstado())) {
            facturaDb.setEstado(factura.getEstado());
        }else {
            facturaDb.setNumeroFactura (factura.getNumeroFactura());
            facturaDb.setCliente (clienteRepository.findById(factura.getIdCliente()).get());
        }
        Factura fbd = repository.save(facturaDb);
        FacturaResponse facturaResponse = new FacturaResponse();
        facturaResponse.setId(fbd.getId());
        facturaResponse.setEstado(fbd.getEstado());
        facturaResponse.setNumeroFactura(fbd.getNumeroFactura());
        facturaResponse.setTotal(fbd.getTotal());
        facturaResponse.setFecha(fbd.getCreateAt());
        facturaResponse.setIdCliente(fbd.getCliente().getIdCliente());
        return facturaResponse;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
