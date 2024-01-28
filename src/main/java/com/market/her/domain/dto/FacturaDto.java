package com.market.her.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FacturaDto {
    private String numeroFactura;
    private String fecha;
    private Double total;
    private String cliente;
    private String proveedor;
    private String estado;


}
