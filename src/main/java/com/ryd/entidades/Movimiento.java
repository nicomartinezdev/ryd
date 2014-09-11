package com.ryd.entidades;

import java.io.Serializable;
import java.util.Date;
import com.ryd.entidades.Cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento implements Serializable{

	private static final long serialVersionUID = 1L;

	private int movimientoId;
	private double monto;
	private Cliente cliente;
	private Date fecha;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_MOVIMIENTO", unique = true, nullable = false)
	public int getMovimientoId() {
		return movimientoId;
	}
	public void setMovimientoId(int movimientoId) {
		this.movimientoId = movimientoId;
	}
	
	@Column(name = "MONTO", nullable = false)
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	@ManyToOne
    @JoinColumn(name="ID_CLIENTE")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Column(name = "FECHA", nullable = false)
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + movimientoId;
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
		Movimiento other = (Movimiento) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (movimientoId != other.movimientoId)
			return false;
		return true;
	}

}
