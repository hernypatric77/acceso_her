package com.market.her.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FacturaRequest {
    private String numeroFactura;
//    private Date fecha;
    private Double total;
    private Long idCliente;
    private String estado;


}
