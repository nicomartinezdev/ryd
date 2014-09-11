package com.ryd.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "remitos")
public class Remito implements Serializable {

	private static final long serialVersionUID = 1L;

	private int remitoId;
	private Cliente cliente;
	private double importe;
	private Date fecha;
	private String observaciones;
	private List<ProductoRemito> productoRemito;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_REMITO", unique = true, nullable = false)
	public int getRemitoId() {
		return remitoId;
	}
	public void setRemitoId(int remitoId) {
		this.remitoId = remitoId;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Column(name = "IMPORTE", nullable = false)
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	@Column(name = "FECHA", nullable = false)
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "OBSERVACIONES", length = 500)
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@OneToMany (mappedBy = "remito")
	public List<ProductoRemito> getProductosRemito() {
		return productoRemito;
	}
	public void setProductosRemito(List<ProductoRemito> productoRemito) {
		this.productoRemito = productoRemito;
	}
	
}
