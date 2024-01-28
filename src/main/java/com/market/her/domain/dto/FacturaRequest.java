package com.market.her.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FacturaRequest {
    private String numeroFactura;
    private Double total;
    private Long idCliente;
    private Long idProvedor;
    private String estado;

    private Long idProducto;


}
