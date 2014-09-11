package com.ryd.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import com.ryd.entidades.ProductoRemito;

public class RemitoForm {

	private int remitoId;
	private int clienteId;
	private String razonSocial;
	private double importe;
	private String fecha;
	private String observaciones;
	
	@SuppressWarnings("unchecked")
	private List<ProductoRemito> productos = LazyList.decorate(new ArrayList<ProductoRemito>(10),
		       FactoryUtils.instantiateFactory(ProductoRemito.class));
	
	public int getRemitoId() {
		return remitoId;
	}
	public void setRemitoId(int remitoId) {
		this.remitoId = remitoId;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public List<ProductoRemito> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoRemito> productos) {
		this.productos = productos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + remitoId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemitoForm other = (RemitoForm) obj;
		if (remitoId != other.remitoId)
			return false;
		return true;
	}
	
}
