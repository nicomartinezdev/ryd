package com.ryd.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import com.ryd.database.dao.ClienteDao;
import com.ryd.database.dao.ProductoRemitoDao;
import com.ryd.database.dao.RemitoDao;
import com.ryd.database.dao.SaldoDao;
import com.ryd.entidades.ProductoRemito;
import com.ryd.entidades.Remito;
import com.ryd.entidades.Saldo;
import com.ryd.model.RemitoForm;
import com.ryd.service.RemitoService;

public class RemitoServiceImpl implements RemitoService {
	
	private RemitoDao remitoDao;
	private ClienteDao clienteDao;
	private ProductoRemitoDao productoRemitoDao;
	private SaldoDao saldoDao;
				     
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Remito get(int remitoId) {
		return remitoDao.get(remitoId);
	}

	public List<Remito> list() {
		return remitoDao.list();
	}

	public List<Remito> listarPorCliente(int clienteId) {
		return remitoDao.listarPorCliente(clienteId);
	}

	public int save(Remito remito) {
		int id = remitoDao.save(remito);
		Saldo saldo = remito.getCliente().getSaldo();
		saldo.setMonto(saldo.getMonto() - remito.getImporte());
		saldoDao.update(saldo);
		for (ProductoRemito pr : remito.getProductosRemito()) {
			pr.setRemito(get(id));
			if (pr.getCantidad() > 0) {
				productoRemitoDao.save(pr);
			}
		}
		return id;
	}

	public void update(Remito remito) {
		Remito oldRemito = get(remito.getRemitoId());
		if (oldRemito.getImporte() != remito.getImporte()) {
			Saldo saldo = remito.getCliente().getSaldo();
			saldo.setMonto(saldo.getMonto() - oldRemito.getImporte() + remito.getImporte());
			saldoDao.update(saldo);
		}
		for (ProductoRemito pr : remito.getProductosRemito()) {
			if (pr.getRemito() == null) {
				pr.setRemito(remito);
				productoRemitoDao.save(pr);
			} else {
				productoRemitoDao.update(pr);
			}
			
		}
		remitoDao.update(remito);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public RemitoForm llenarForm(int remitoId) {
		Remito remito = get(remitoId);
		Integer anio = remito.getFecha().getYear()+1900;
		Integer mes = remito.getFecha().getMonth()+1;
		Integer dia = remito.getFecha().getDate();
		RemitoForm form = new RemitoForm();
		form.setRemitoId(remitoId);
		form.setClienteId(remito.getCliente().getClienteId());
		
		form.setFecha(dia+"/"+mes+"/"+anio.toString());
		form.setImporte(remito.getImporte());
		form.setObservaciones(remito.getObservaciones());
		form.setRazonSocial(remito.getCliente().getRazonSocial());
		form.setProductos(remito.getProductosRemito());
		form.setProductos(LazyList.decorate(remito.getProductosRemito(),
			       FactoryUtils.instantiateFactory(ProductoRemito.class)));
		return form;
	}

	public Remito llenarRemito(RemitoForm form) {
		Remito remito = new Remito();
		
		try {
			remito.setFecha(df.parse(form.getFecha()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		remito.setImporte(form.getImporte());
		remito.setObservaciones(form.getObservaciones());
		remito.setProductosRemito(form.getProductos());
		remito.setRemitoId(form.getRemitoId());
		remito.setCliente(clienteDao.get(form.getClienteId()));
		return remito;
	}

	public RemitoDao getRemitoDao() {
		return remitoDao;
	}

	public void setRemitoDao(RemitoDao remitoDao) {
		this.remitoDao = remitoDao;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public ProductoRemitoDao getProductoRemitoDao() {
		return productoRemitoDao;
	}

	public void setProductoRemitoDao(ProductoRemitoDao productoRemitoDao) {
		this.productoRemitoDao = productoRemitoDao;
	}

	public SaldoDao getSaldoDao() {
		return saldoDao;
	}

	public void setSaldoDao(SaldoDao saldoDao) {
		this.saldoDao = saldoDao;
	}
	
}
