package com.ryd.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ryd.database.dao.ClienteDao;
import com.ryd.database.dao.MovimientoDao;
import com.ryd.database.dao.SaldoDao;
import com.ryd.entidades.Cliente;
import com.ryd.entidades.Movimiento;
import com.ryd.entidades.Saldo;
import com.ryd.model.MovimientoForm;
import com.ryd.service.MovimientoService;

public class MovimientoServiceImpl implements MovimientoService {

	private MovimientoDao movimientoDao;
	private ClienteDao clienteDao;
	private SaldoDao saldoDao;
	
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Movimiento get(int movimientoId) {
		return movimientoDao.get(movimientoId);
	}

	public List<Movimiento> list() {
		return movimientoDao.list();
	}

	public List<Movimiento> buscar(int clienteId, String fecha) {
		Cliente cliente = clienteDao.get(clienteId);
		List<Movimiento> lista = new ArrayList<Movimiento>();
		try {
			lista = movimientoDao.buscar(cliente.getSaldo().getSaldoId(), df.parse(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
			lista = movimientoDao.buscar(cliente.getSaldo().getSaldoId(), null);
		}
		return lista;
	}

	public int save(Movimiento movimiento) {
		int id = movimientoDao.save(movimiento);
		Saldo saldo = movimiento.getCliente().getSaldo();
		saldo.setMonto(saldo.getMonto() + movimiento.getMonto());
		saldoDao.update(saldo);
		return id;
	}

	public void update(Movimiento movimiento) {
		Movimiento oldMovimiento = get(movimiento.getMovimientoId());
		Saldo saldo = movimiento.getCliente().getSaldo();
		saldo.setMonto(saldo.getMonto() - oldMovimiento.getMonto() + movimiento.getMonto());
		saldoDao.update(saldo);
		movimientoDao.update(movimiento);
	}
	
	public void delete(Movimiento movimiento) {
		Saldo saldo = movimiento.getCliente().getSaldo();
		saldo.setMonto(saldo.getMonto() - movimiento.getMonto());
		saldoDao.update(saldo);
		movimientoDao.delete(movimiento);
	}

	public MovimientoForm llenarForm(int movimientoId) {
		Movimiento movimiento = get(movimientoId);
		MovimientoForm form = new MovimientoForm();
		form.setFecha(df.format(movimiento.getFecha()));
		form.setMonto(movimiento.getMonto());
		form.setMovimientoId(movimiento.getMovimientoId());
		form.setClienteId(movimiento.getCliente().getClienteId());
		form.setRazonSocial(movimiento.getCliente().getRazonSocial());
		return form;
	}

	public Movimiento llenarMovimiento(MovimientoForm form) {
		Movimiento movimiento = new Movimiento();
		try {
			movimiento.setFecha(df.parse(form.getFecha()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movimiento.setMonto(form.getMonto());
		movimiento.setMovimientoId(form.getMovimientoId());
		movimiento.setCliente(clienteDao.get(form.getClienteId()));
		return movimiento;
	}

	public MovimientoDao getMovimientoDao() {
		return movimientoDao;
	}

	public void setMovimientoDao(MovimientoDao movimientoDao) {
		this.movimientoDao = movimientoDao;
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
