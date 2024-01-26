package com.market.her.persistence.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;
	private String nombre;
	private String apellido;
	private String email;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturaList;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

}
