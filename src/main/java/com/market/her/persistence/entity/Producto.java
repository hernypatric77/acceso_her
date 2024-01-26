package com.market.her.persistence.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long idProducto;
	private String nombre;
	private Double valorUnitario;
	private String stock;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.MERGE)
	private List<DetalleFactura> detallefacturas;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
