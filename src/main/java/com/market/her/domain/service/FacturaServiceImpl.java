package com.market.her.domain.service;

import com.market.her.domain.dto.FacturaRequest;
import com.market.her.domain.dto.FacturaResponse;
import com.market.her.persistence.crud.*;
import com.market.her.persistence.entity.DetalleFactura;
import com.market.her.persistence.entity.Factura;
import com.market.her.persistence.entity.Producto;
import com.market.her.persistence.entity.Proveedor;
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
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
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
            facResp.setId(factura.getIdFactura());
            facResp.setEstado(factura.getEstado());
            facResp.setNumeroFactura(factura.getNumeroFactura());
            facResp.setFecha(factura.getCreateAt());
            facResp.setTotal(factura.getTotal());
            facResp.setIdCliente(factura.getCliente().getIdCliente());
            facResp.setIdProvedor(factura.getProveedor().getIdProveedor());
            List<DetalleFactura> listDetalle = detalleFacturaRepository.findByFactura(factura);
            facResp.setIdProducto(listDetalle.isEmpty()? null: listDetalle.get(0).getProducto().getIdProducto());

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
        fac.setProveedor(proveedorRepository.findById(facturaR.getIdProvedor()).get());
        Factura fbd = repository.save(fac);
        detalleFacturaRepository.save(this.createDetalle(fbd, facturaR.getIdProducto()));

        FacturaResponse facturaResponse = new FacturaResponse();
        facturaResponse.setId(fbd.getIdFactura());
        facturaResponse.setEstado(fbd.getEstado());
        facturaResponse.setNumeroFactura(fbd.getNumeroFactura());
        facturaResponse.setTotal(fbd.getTotal());
        facturaResponse.setFecha(fbd.getCreateAt());
        facturaResponse.setIdCliente(fbd.getCliente().getIdCliente());
        return facturaResponse;
    }

    private DetalleFactura createDetalle(Factura factura, Long idProducto) {
        DetalleFactura det = new DetalleFactura();
        det.setFactura(factura);
        det.setCantidad(1);
        Producto producto = productoRepository.findById(idProducto).get();
        det.setProducto(producto);
        det.setSubtotal((det.getCantidad() * producto.getValorUnitario()));
        det.setValorIva(producto.getValorUnitario()* 12 / 100);
        return det;

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
        facturaResponse.setId(fbd.getIdFactura());
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
