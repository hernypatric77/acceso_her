package com.market.her.persistence.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "detalle_factura")
@Data
public class DetalleFactura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_det")
	private Long idDetalle;

	@ManyToOne
	@JoinColumn(name = "id")
	private Factura factura;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	private Double subtotal;
	private Integer cantidad;
	@Column(name = "valor_iva")
	private Double valorIva;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
