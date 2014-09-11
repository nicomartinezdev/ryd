package com.ryd.database.dao;

import java.util.List;

import com.ryd.entidades.Remito;

public interface RemitoDao {
	public Remito get(int remitoId);
	public List<Remito> list();
	public List<Remito> listarPorCliente(int clienteId);
	public int save(Remito remito);
	public void update(Remito remito);
}
