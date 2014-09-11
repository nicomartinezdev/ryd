package com.ryd.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos_remito")
public class ProductoRemito implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productosRemitoId;
	private Remito remito;
	private Producto producto = new Producto();
	private int cantidad;
	private String detalle;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_PRODUCTOS_REMITO", unique = true, nullable = false)
	public int getProductosRemitoId() {
		return productosRemitoId;
	}
	public void setProductosRemitoId(int productosRemitoId) {
		this.productosRemitoId = productosRemitoId;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_REMITO")
	public Remito getRemito() {
		return remito;
	}
	public void setRemito(Remito remito) {
		this.remito = remito;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Column(name = "CANTIDAD", nullable = false)
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name = "DETALLE", nullable = false, length = 200)
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
}
