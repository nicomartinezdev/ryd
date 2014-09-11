package com.ryd.service;

import java.util.List;

import com.ryd.entidades.Remito;
import com.ryd.model.RemitoForm;

public interface RemitoService {
	public Remito get(int remitoId);
	public List<Remito> list();
	public List<Remito> listarPorCliente(int clienteId);
	public int save(Remito remito);
	public void update(Remito remito);
	public RemitoForm llenarForm(int remitoId);
	public Remito llenarRemito(RemitoForm form);
}
