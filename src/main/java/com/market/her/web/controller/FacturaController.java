package com.market.her.web.controller;

import com.market.her.domain.dto.FacturaRequest;
import com.market.her.domain.dto.FacturaResponse;
import com.market.her.domain.service.FacturaService;
import com.market.her.persistence.entity.Factura;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService service;

    @GetMapping("/")
    @ApiOperation("Obtener lista de facturas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findEstado());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<Factura> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody FacturaRequest facturaRequest){
        FacturaResponse facturaDb = service.save(facturaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody FacturaRequest  factura, @PathVariable Long id){
        Optional<Factura> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(factura, o));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
