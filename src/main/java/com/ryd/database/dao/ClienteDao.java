package com.ryd.database.dao;

import java.util.List;

import com.ryd.entidades.Cliente;

public interface ClienteDao {
	public Cliente get(int clienteId);
	public Cliente getBySaldo(int saldoId);
	public List<Cliente> list();
	public int save(Cliente cliente);
	public void update(Cliente cliente);
	public List<Cliente> buscar(String razonSocial);
	public boolean validarRazonSocial(int clienteId, String razonSocial);
}
