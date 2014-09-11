package com.ryd.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int clienteId;
	private String razonSocial;
	private String cuit;
	private String direccion;
	private String telLaboral;
	private String celular;
	private String telParticular;
	private String nextel;
	private String mail;
	private String contacto;
	private String observaciones;
	private Saldo saldo;
	
	public Cliente(int clienteId) {
		this.clienteId = clienteId;
	}
	
	public Cliente() {
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_CLIENTE", unique = true, nullable = false)
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	
	@Column(name = "RAZON_SOCIAL", nullable = false, length = 100)
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	@Column(name = "CUIT", length = 15)
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	@Column(name = "DIRECCION", length = 100)
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column(name = "TEL_LABORAL", length = 20)
	public String getTelLaboral() {
		return telLaboral;
	}
	public void setTelLaboral(String telLaboral) {
		this.telLaboral = telLaboral;
	}
	
	@Column(name = "CELULAR", length = 20)
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	@Column(name = "TEL_PARTICULAR", length = 20)
	public String getTelParticular() {
		return telParticular;
	}
	public void setTelParticular(String telParticular) {
		this.telParticular = telParticular;
	}
	
	@Column(name = "NEXTEL", length = 10)
	public String getNextel() {
		return nextel;
	}
	public void setNextel(String nextel) {
		this.nextel = nextel;
	}
	
	@Column(name = "MAIL", length = 50)
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name = "CONTACTO", length = 50)
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	@Column(name = "OBSERVACIONES", length = 500)
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@OneToOne
	@JoinColumn(name="ID_SALDO")
	public Saldo getSaldo() {
		return saldo;
	}
	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clienteId;
		result = prime * result
				+ ((razonSocial == null) ? 0 : razonSocial.hashCode());
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
		Cliente other = (Cliente) obj;
		if (clienteId != other.clienteId)
			return false;
		if (razonSocial == null) {
			if (other.razonSocial != null)
				return false;
		} else if (!razonSocial.equals(other.razonSocial))
			return false;
		return true;
	}
	
}
