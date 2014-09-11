package com.ryd.service.impl;

import java.util.List;

import com.ryd.database.dao.ClienteDao;
import com.ryd.database.dao.SaldoDao;
import com.ryd.entidades.Cliente;
import com.ryd.entidades.Saldo;
import com.ryd.model.ClienteForm;
import com.ryd.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

	private ClienteDao clienteDao;
	private SaldoDao saldoDao;
	
	public Cliente get(int clienteId) {
		return clienteDao.get(clienteId);
	}

	public List<Cliente> list() {
		return clienteDao.list();
	}

	public int save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	public void update(Cliente cliente) {
		clienteDao.update(cliente);
	}

	public ClienteForm llenarForm(int clienteId) {
		ClienteForm form = new ClienteForm();
		Cliente cliente = get(clienteId);
		form.setClienteId(clienteId);
		form.setCelular(cliente.getCelular());
		form.setContacto(cliente.getContacto());
		form.setCuit(cliente.getCuit());
		form.setDireccion(cliente.getDireccion());
		form.setMail(cliente.getMail());
		if (cliente.getSaldo() != null) {
			form.setMontoSaldo(cliente.getSaldo().getMonto());
			form.setSaldoId(cliente.getSaldo().getSaldoId());
		} else {
			form.setMontoSaldo(0);
			form.setSaldoId(0);
		}
		form.setNextel(cliente.getNextel());
		form.setObservaciones(cliente.getObservaciones());
		form.setRazonSocial(cliente.getRazonSocial());
		form.setTelLaboral(cliente.getTelLaboral());
		form.setTelParticular(cliente.getTelParticular());
		
		return form;
	}

	public Cliente llenarCliente(ClienteForm form) {
		Cliente cliente = new Cliente();
		Saldo saldo = saldoDao.get(form.getSaldoId());
		if (saldo != null) {
			saldo.setMonto(form.getMontoSaldo());
			saldoDao.update(saldo);
		} else {
			saldo = new Saldo();
			saldo.setMonto(form.getMontoSaldo());
			int saldoId = saldoDao.save(saldo);
			saldo = saldoDao.get(saldoId);
		}
		cliente.setSaldo(saldo);
		cliente.setCelular(form.getCelular());
		cliente.setClienteId(form.getClienteId());
		cliente.setContacto(form.getContacto());
		cliente.setCuit(form.getCuit());
		cliente.setDireccion(form.getDireccion());
		cliente.setMail(form.getMail());
		cliente.setNextel(form.getNextel());
		cliente.setObservaciones(form.getObservaciones());
		cliente.setRazonSocial(form.getRazonSocial());
		cliente.setTelLaboral(form.getTelLaboral());
		cliente.setTelParticular(form.getTelParticular());

		return cliente;
	}

	public List<Cliente> buscar(String razonSocial) {
		return clienteDao.buscar(razonSocial);
	}
	
	public boolean validarRazonSocial(int clienteId, String razonSocial) {
		return clienteDao.validarRazonSocial(clienteId, razonSocial);
	}
	
	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public SaldoDao getSaldoDao() {
		return saldoDao;
	}

	public void setSaldoDao(SaldoDao saldoDao) {
		this.saldoDao = saldoDao;
	}

}
