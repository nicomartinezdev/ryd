package com.ryd.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saldo")
public class Saldo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int saldoId;
	private double monto;

	public Saldo(int saldoId) {
		this.saldoId = saldoId;
		this.monto = 0;
	}
	
	public Saldo() {
		
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_SALDO", unique = true, nullable = false)
	public int getSaldoId() {
		return saldoId;
	}
	public void setSaldoId(int saldoId) {
		this.saldoId = saldoId;
	}
	
	@Column(name = "MONTO", nullable = false)
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}

	public boolean esPositivo() {
		return monto >= 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + saldoId;
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
		Saldo other = (Saldo) obj;
		if (saldoId != other.saldoId)
			return false;
		return true;
	}
	
}
