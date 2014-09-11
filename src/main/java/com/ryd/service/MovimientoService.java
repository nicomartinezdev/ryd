package com.ryd.service;

import java.util.List;

import com.ryd.entidades.Movimiento;
import com.ryd.model.MovimientoForm;

public interface MovimientoService {
	public Movimiento get(int movimientoId);
	public List<Movimiento> list();
	public List<Movimiento> buscar(int clienteId, String fecha);
	public int save(Movimiento movimiento);
	public void update(Movimiento movimiento);
	public void delete(Movimiento movimiento);
	public MovimientoForm llenarForm(int movimientoId);
	public Movimiento llenarMovimiento(MovimientoForm form);
}
