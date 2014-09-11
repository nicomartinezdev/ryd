package com.ryd.service;

import java.util.List;

import com.ryd.entidades.Cliente;
import com.ryd.model.ClienteForm;

public interface ClienteService {
	public Cliente get(int clienteId);
	public List<Cliente> list();
	public int save(Cliente cliente);
	public void update(Cliente cliente);
	public ClienteForm llenarForm(int clienteId);
	public Cliente llenarCliente(ClienteForm form);
	public List<Cliente> buscar(String razonSocial);
	public boolean validarRazonSocial(int clienteId, String razonSocial);
}
