package com.ryd.database.dao;

import java.util.List;

import com.ryd.entidades.Saldo;

public interface SaldoDao {
	public Saldo get(int saldoId);
	public List<Saldo> list();
	public int save(Saldo saldo);
	public void update(Saldo saldo);
}
