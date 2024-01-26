package com.market.her.persistence.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Long idProveedor;
	private String nombre;
	private String direccion;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@OneToMany(mappedBy = "proveedor")
	private List<Factura> facturaList;

	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.MERGE)
	private List<Producto> productoList;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
