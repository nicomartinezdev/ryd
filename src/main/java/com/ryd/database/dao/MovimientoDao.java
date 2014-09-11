package com.ryd.database.dao;

import java.util.Date;
import java.util.List;

import com.ryd.entidades.Movimiento;

public interface MovimientoDao {
	public Movimiento get(int movimientoId);
	public List<Movimiento> list();
	public List<Movimiento> buscar(int clienteId, Date fecha);
	public int save(Movimiento movimiento);
	public void update(Movimiento movimiento);
	public void delete(Movimiento movimiento);
}
