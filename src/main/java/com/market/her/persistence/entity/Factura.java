package com.market.her.persistence.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
@Data
@ToString(callSuper = true, of = {"id", "numeroFactura", "total"})
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_factura")
	private String numeroFactura;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	private Double total;

	private String estado;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.MERGE)
	private List<DetalleFactura> detallefacturas;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
